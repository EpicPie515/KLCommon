package lol.kangaroo.common.player;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import lol.kangaroo.common.database.DatabaseManager;
import lol.kangaroo.common.permissions.IGrantable;
import lol.kangaroo.common.permissions.Rank;
import lol.kangaroo.common.util.ObjectMutable;

public class PlayerGrants {
	
	private static DatabaseManager db;
	
	private BasePlayer bp;
	private Set<PlayerGrant> grants;
	private PlayerGrant effectiveGrant;
	
	private PlayerGrants(BasePlayer bp, PlayerGrant effectiveGrant, Set<PlayerGrant> grants) {
		this.bp = bp;
		this.effectiveGrant = effectiveGrant;
		this.grants = grants;
	}
	
	public static void init(DatabaseManager databaseManager) {
		db = databaseManager;
	}
	
	public UUID getUniqueId() {
		return bp.getUniqueId();
	}

	public Set<PlayerGrant> getGrants() {
		return grants;
	}

	public PlayerGrant getEffectiveGrant() {
		return effectiveGrant;
	}
	
	/**
	 * Adds a grant to the list, if its higher priority it will replace the effectivegrant, and add to database.
	 * Should be ASYNC
	 * Returns whether the new grant is now the effective one. (PlayerManager will apply the rank)
	 */
	public boolean addGrant(PlayerGrant grant) {
		grants.add(grant);
		db.update("INSERT INTO `player_grants` (`GRANTID`, `UUID`, `RANKID`, `DURATION`, `ACTIVATED_TIMESTAMP`, `EXPIRED`) VALUES (NULL, ?, ?, ?, ?, ?);",
				bp.getUniqueId(), grant.getRank().getId(), grant.getDuration(), grant.getActivatedTimestamp(), grant.isExpired());
		if(grant.getRank().getId() > effectiveGrant.getRank().getId()) {
			deactivate(effectiveGrant);
			effectiveGrant = grant;
			return true;
		} else
			return false;
		
	}
	
	/**
	 * Adds the default PLAYER grant to the player.
	 * @return the PLAYER grant
	 */
	public PlayerGrant addDefaultGrant() {
		PlayerGrant g = createDefaultGrant(getUniqueId());
		grants.add(g);
		if(effectiveGrant == null) effectiveGrant = g;
		return g;
	}
	
	/**
	 * Reassures effectivegrant is highest rank grant, then makes sure its active.
	 * @return whether the effective grant was activated. (not whether its new, could have been effective but never activated
	 * (if true should tell the player and apply rank)
	 */
	public boolean verifyEffectiveGrant() {
		// if effectiveGrant is null it will keep everything in filter to sort and apply.
		Optional<PlayerGrant> newEffective = grants.stream().filter(g -> (effectiveGrant == null || effectiveGrant.getActivatedTimestamp() == null) || (g.getRank().getId() > effectiveGrant.getRank().getId())).sorted((g1,g2) -> Rank.compare(g1.getRank(), g2.getRank())).findFirst();
		// if the grants set is empty and effective is null, add default
		if(!newEffective.isEmpty())
			effectiveGrant = newEffective.get();
		else if(effectiveGrant == null) addDefaultGrant();
		
		if(!effectiveGrant.isActive()) {
			grants.stream().filter(g1 -> g1.isActive()).forEach(g2 -> deactivate(g2));
			effectiveGrant.activatedTimestamp = new Timestamp(System.currentTimeMillis());
			db.update("UPDATE `player_grants` SET `ACTIVATED_TIMESTAMP`=CURRENT_TIMESTAMP() WHERE `UUID`=? AND `GRANTID`=?", effectiveGrant.getUniqueId(), effectiveGrant.getGrantId());
			return true;
		}
		return false;
	}
	
	/**
	 * Pushes the timestamp to now, adjusts the duration.
	 */
	public void pushTimestamp(PlayerGrant g) {
		long durLeft = g.getDuration() - ((System.currentTimeMillis() - g.getActivatedTimestamp().getTime()));
		if(durLeft == 0) durLeft = -1;
		g.duration = durLeft;
		g.activatedTimestamp = new Timestamp(System.currentTimeMillis());
		db.update("UPDATE `player_grants` SET `ACTIVATED_TIMESTAMP`=CURRENT_TIMESTAMP(), `DURATION`=? WHERE `UUID`=? AND `GRANTID`=?", g.getDuration(), g.getUniqueId(), g.getGrantId());
	}
	
	/**
	 * Adjusts duration to current time remaining, nulls timestamp
	 * @return true if was active, false if already deactivated.
	 */
	public boolean deactivate(PlayerGrant g) {
		if(!g.isActive()) return false;
		long durLeft = g.getDuration() - ((System.currentTimeMillis() - g.getActivatedTimestamp().getTime()));
		if(durLeft == 0) durLeft = -1;
		g.duration = durLeft;
		g.activatedTimestamp = null;
		db.update("UPDATE `player_grants` SET `ACTIVATED_TIMESTAMP`=NULL, `DURATION`=? WHERE `UUID`=? AND `GRANTID`=?", g.getDuration(), g.getUniqueId(), g.getGrantId());
		return true;
	}
	
	public List<PlayerGrant> updateExpiring() {
		verifyEffectiveGrant();
		List<PlayerGrant> expiring = new ArrayList<>();
		
		long curActivated = effectiveGrant.getActivatedTimestamp().getTime();
		Iterator<PlayerGrant> it = grants.stream()
					.sorted((g1,g2) -> Rank.compare(g1.getRank(), g2.getRank()))
					.iterator();
		while(it.hasNext()) {
			PlayerGrant g = it.next();
			if(effectiveGrant == null)
				effectiveGrant = g;
			// g is effectiveGrant always
			
			if(effectiveGrant.getDuration() == 0)
				break;
			
			if((effectiveGrant.getDuration() < 0) || curActivated + effectiveGrant.getDuration() < System.currentTimeMillis()) {
				curActivated += effectiveGrant.getDuration();
				effectiveGrant = null;
				expiring.add(g);
				continue;
			}
			
			// not expiring, keep effectivegrant and break.
			break;
		}
		// never got to a non-expiring grant, add the perm default grant.
		if(effectiveGrant == null)
			addDefaultGrant();
		
		grants.removeAll(expiring);
		String[] grantIds = (String[]) expiring.stream().mapToInt(PlayerGrant::getGrantId).mapToObj(Integer::toString).toArray();
		String grantIdStr = String.join(",", grantIds);
		db.update("UPDATE `player_grants` SET `EXPIRED`=TRUE WHERE `GRANTID` IN(?)", grantIdStr);
		return expiring;
	}

	public static class PlayerGrant implements IGrantable {
		
		private UUID uuid;
		private int grantId;
		private Rank rank;
		private long duration;
		private Timestamp activatedTimestamp;
		private boolean expired;
		
		

		public PlayerGrant(UUID uuid, int grantId, Rank rank, long duration, Timestamp activatedTimestamp, boolean expired) {
			this.uuid = uuid;
			this.grantId = grantId;
			this.rank = rank;
			this.duration = duration;
			this.activatedTimestamp = activatedTimestamp;
			this.expired = expired;
		}

		public UUID getUniqueId() {
			return uuid;
		}
		
		public int getGrantId() {
			return grantId;
		}

		public Rank getRank() {
			return rank;
		}
		
		public long getDuration() {
			return duration;
		}
		
		public Timestamp getActivatedTimestamp() {
			return activatedTimestamp;
		}
		
		public boolean isExpired() {
			return expired;
		}
		
		public boolean isActive() {
			return activatedTimestamp != null && !expired;
		}
		
		@Override
		public boolean equals(Object obj) {
			return (obj instanceof PlayerGrant) && getGrantId()==((PlayerGrant) obj).getGrantId();
		}
	}
	
	public static PlayerGrant createDefaultGrant(UUID uuid) {
		int gid = db.updateWithId("INSERT INTO `player_grants` (`GRANTID`, `UUID`, `RANKID`, `DURATION`, `ACTIVATED_TIMESTAMP`, `EXPIRED`) VALUES (NULL, ?, ?, '0', CURRENT_TIMESTAMP(), ?);", uuid, Rank.PLAYER.getId(), false);
		if(gid == 0) {
			throw new RuntimeException("Last insert id didnt work");
		}
		PlayerGrant g = new PlayerGrant(uuid, gid, Rank.PLAYER, 0, new Timestamp(System.currentTimeMillis()), false);
		return g;
	}
	
	/**
	 * Gets the non-expired player grants from the database for that player.
	 * 
	 * Excludes all expired grants.
	 * 
	 * Should be run async.
	 * @param p the Player to get the history of.
	 * @return the PlayerHistory of the given player.
	 */
	public static PlayerGrants getPlayerGrants(BasePlayer p) {
		UUID u = p.getUniqueId();
		Set<PlayerGrant> grants = new HashSet<>();
		ObjectMutable<PlayerGrant> effectiveGrant = new ObjectMutable<PlayerGrant>(null);
		db.query("SELECT `GRANTID`, `RANKID`, `DURATION`, `ACTIVATED_TIMESTAMP`, `EXPIRED` FROM `player_grants` WHERE `UUID`=? AND (`DURATION`='0' OR `EXPIRED`=FALSE) ORDER BY `RANKID` DESC;", rs -> {
			try {
				while(rs.next()) {
					int gid = rs.getInt(1);
					Rank rank = Rank.getById(rs.getInt(2));
					long dur = rs.getLong(3);
					Timestamp ts = rs.getTimestamp(4);
					boolean exp = rs.getBoolean(5);
					PlayerGrant g = new PlayerGrant(u, gid, rank, dur, ts, exp);
					grants.add(g);
					if(effectiveGrant.get() == null) {
						effectiveGrant.set(g);
					}
				}
				if(effectiveGrant.get() == null) {
					PlayerGrant defGrant = createDefaultGrant(u);
					effectiveGrant.set(defGrant);
					grants.add(defGrant);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, u);
		return new PlayerGrants(p, effectiveGrant.get(), grants);
	}
	
}
