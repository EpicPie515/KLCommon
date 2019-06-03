package lol.kangaroo.common.permissions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

import lol.kangaroo.common.database.DatabaseManager;
import lol.kangaroo.common.player.BasePlayer;
import lol.kangaroo.common.player.PlayerVariable;
import lol.kangaroo.common.util.DoubleObject;

public class PermissionManager {
	
	private DatabaseManager db;
	
	public PermissionManager(DatabaseManager db) {
		this.db = db;
	}
	
	public boolean hasPermission(BasePlayer p, String perm) {
		Map<String, Boolean> perms = getAllPermissions(p);
		return perms.containsKey(perm) && perms.get(perm);
	}
	
	public boolean hasPlayerPermission(BasePlayer p, String perm) {
		Map<String, Boolean> perms = getPlayerPermissions(p);
		return perms.containsKey(perm) && perms.get(perm);
	}
	
	/**
	 * does not include rank super-perms.
	 */
	public boolean hasRankPermission(Rank rank, String perm) {
		Map<String, Boolean> perms = getRankPermissions(rank);
		return perms.containsKey(perm) && perms.get(perm);
	}
	
	public boolean hasRankSuperperm(Rank rank, String perm) {
		Map<String, Boolean> perms = getRankSuperperms(rank);
		return perms.containsKey(perm) && perms.get(perm);
	}
	
	public void setPlayerPermission(BasePlayer p, String perm, boolean value) {
		db.update("INSERT INTO `player_perms` (`UUID`, `PERM`, `VALUE`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `VALUE`=?", p.getUniqueId(), perm, value, value);
	}
	
	public void setPlayerPermissions(BasePlayer p, Map<String, Boolean> perms) {
		Set<DoubleObject<String, Object[]>> updates = new HashSet<>();
		for(Entry<String, Boolean> e : perms.entrySet()) {
			updates.add(new DoubleObject<>("INSERT INTO `player_perms` (`UUID`, `PERM`, `VALUE`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `VALUE`=?", new Object[] { p.getUniqueId(), e.getKey(), e.getValue(), e.getValue()}));
		}
		db.multiUpdate(updates);
	}

	public void setRankPermission(Rank rank, String perm, boolean value) {
		db.update("INSERT INTO `rank_perms` (`RANK`, `PERM`, `VALUE`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `VALUE`=?", rank, perm, value, value);
	}
	
	public void setRankPermissions(Rank rank, Map<String, Boolean> perms) {
		Set<DoubleObject<String, Object[]>> updates = new HashSet<>();
		for(Entry<String, Boolean> e : perms.entrySet()) {
			updates.add(new DoubleObject<>("INSERT INTO `rank_perms` (`RANK`, `PERM`, `VALUE`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `VALUE`=?", new Object[] { rank, e.getKey(), e.getValue(), e.getValue()}));
		}
		db.multiUpdate(updates);
	}
	
	public void removePlayerPermission(BasePlayer p, String perm) {
		db.update("DELETE FROM `player_perms` WHERE `UUID`=? AND `PERM`=?", p.getUniqueId(), perm);
	}
	
	public void removePlayerPermissions(BasePlayer p, Set<String> perms) {
		Set<DoubleObject<String, Object[]>> updates = new HashSet<>();
		for(String perm : perms) {
			updates.add(new DoubleObject<>("DELETE FROM `player_perms` WHERE `UUID`=? AND `PERM`=?", new Object[] {p.getUniqueId(), perm}));
		}
		db.multiUpdate(updates);
	}
	
	public void removeAllPlayerPermissions(BasePlayer p) {
		db.update("DELETE FROM `player_perms` WHERE `UUID`=?", p.getUniqueId());
	}
	
	public void removeRankPermission(Rank rank, String perm) {
		db.update("DELETE FROM `rank_perms` WHERE `RANK`=? AND `PERM`=?", rank, perm);
	}
	
	public void removeRankPermissions(Rank rank, Set<String> perms) {
		Set<DoubleObject<String, Object[]>> updates = new HashSet<>();
		for(String perm : perms) {
			updates.add(new DoubleObject<>("DELETE FROM `rank_perms` WHERE `RANK`=? AND `PERM`=?", new Object[] {rank, perm}));
		}
		db.multiUpdate(updates);
	}
	
	public void removeAllRankPermissions(Rank rank) {
		db.update("DELETE FROM `rank_perms` WHERE `RANK`=?", rank);
	}
	
	
	public Map<String, Boolean> getAllPermissions(BasePlayer bp) {
		Map<String, Boolean> perms = new HashMap<>();
		Map<DoubleObject<String, Object[]>, Consumer<ResultSet>> queries = new HashMap<>();
		queries.put(
				new DoubleObject<>("SELECT `PERM`, `VALUE` FROM `rank_perms` WHERE `RANK`=(SELECT `VALUE` FROM `player_data` WHERE `UUID`=? AND `TYPE`=?)",
				new Object[] {bp.getUniqueId(), PlayerVariable.RANK.getDBColumn()}),
				rs -> {
			try {
				while(rs.next())
					perms.put(rs.getString(1), rs.getBoolean(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		queries.put(
				new DoubleObject<>("SELECT `PERM`, `VALUE` FROM `player_perms` WHERE `UUID`=?",
				new Object[] {bp.getUniqueId()}),
				rs -> {
			try {
				while(rs.next())
					perms.put(rs.getString(1), rs.getBoolean(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		Rank rank = (Rank) bp.getVariable(PlayerVariable.RANK);
		for(Rank r : Rank.values())
			if(r.getLevel() <= rank.getLevel())
				perms.put(r.getPerm(), true);
			else perms.put(r.getPerm(), false);
		db.multiQuery(queries);
		return perms;
	}
	
	public Map<String, Boolean> getPlayerPermissions(BasePlayer bp) {
		Map<String, Boolean> perms = new HashMap<>();
		db.query("SELECT `PERM`, `VALUE` FROM `player_perms` WHERE `UUID`=?", rs -> {
			try {
				while(rs.next())
					perms.put(rs.getString(1), rs.getBoolean(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, bp.getUniqueId());
		return perms;
	}
	
	public Map<String, Boolean> getRankSuperperms(Rank rank) {
		Map<String, Boolean> perms = new HashMap<>();
		for(Rank r : Rank.values())
			if(r.getLevel() <= rank.getLevel())
				perms.put(r.getPerm(), true);
			else perms.put(r.getPerm(), false);
		return perms;
	}
	
	/**
	 * This does not include the rank's superperm.
	 */
	public Map<String, Boolean> getRankPermissions(BasePlayer bp) {
		Map<String, Boolean> perms = new HashMap<>();
		db.query("SELECT `PERM`, `VALUE` FROM `rank_perms` WHERE `RANK`=(SELECT `VALUE` FROM `player_data` WHERE `UUID`=? AND `TYPE`=?)", rs -> {
			try {
				while(rs.next())
					perms.put(rs.getString(1), rs.getBoolean(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, bp.getUniqueId(), PlayerVariable.RANK.getDBColumn());
		return perms;
	}
	
	/**
	 * This does not include the rank's superperm.
	 */
	public Map<String, Boolean> getRankPermissions(Rank rank) {
		Map<String, Boolean> perms = new HashMap<>();
		db.query("SELECT `PERM`, `VALUE` FROM `rank_perms` WHERE `RANK`=?", rs -> {
			try {
				while(rs.next())
					perms.put(rs.getString(1), rs.getBoolean(2));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, rank);
		return perms;
	}

}
