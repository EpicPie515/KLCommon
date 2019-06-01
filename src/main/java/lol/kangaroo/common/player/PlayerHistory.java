package lol.kangaroo.common.player;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import lol.kangaroo.common.database.DatabaseManager;
import lol.kangaroo.common.util.DoubleObject;

public class PlayerHistory {
	
	private static DatabaseManager db;
	
	private UUID uuid;
	private Set<DoubleObject<String, Long>> nameHistory;
	private Set<DoubleObject<InetAddress, Long>> ipHistory;
	private Set<DoubleObject<String, Long>> nicknameHistory;
	
	private PlayerHistory(UUID uuid, Set<DoubleObject<String, Long>> nameHistory, 
			Set<DoubleObject<InetAddress, Long>> ipHistory, 
			Set<DoubleObject<String, Long>> nicknameHistory) {
		this.uuid = uuid;
		this.nameHistory = nameHistory;
		this.ipHistory = ipHistory;
		this.nicknameHistory = nicknameHistory;
	}

	public Set<DoubleObject<String, Long>> getNameHistory() {
		return nameHistory;
	}

	public Set<DoubleObject<InetAddress, Long>> getIPHistory() {
		return ipHistory;
	}

	public Set<DoubleObject<String, Long>> getNicknameHistory() {
		return nicknameHistory;
	}
	
	public HistoryUpdateCache createUpdateCache() {
		return new HistoryUpdateCache();
	}
	
	public static void init(DatabaseManager databaseManager) {
		db = databaseManager;
	}
	
	public class HistoryUpdateCache {
		
		private Set<DoubleObject<String, Long>> nameUpdate = new HashSet<>();
		private Set<DoubleObject<InetAddress, Long>> ipUpdate = new HashSet<>();
		private Set<DoubleObject<String, Long>> nicknameUpdate = new HashSet<>();
		
		private HistoryUpdateCache() {
		}
		
		public void addName(String name, long initial) {
			nameUpdate.add(new DoubleObject<>(name, initial));
		}
		
		public void addIp(InetAddress ip, long initial) {
			ipUpdate.add(new DoubleObject<>(ip, initial));
		}
		
		public void addNickname(String nickname, long initial) {
			nicknameUpdate.add(new DoubleObject<>(nickname, initial));
		}
		
		public void pushUpdates() {
			Set<DoubleObject<String, Object[]>> updates = new HashSet<>();
			for(DoubleObject<String, Long> name : nameUpdate)
				updates.add(new DoubleObject<>("INSERT INTO `prev_names` (`UUID`, `NAME`, `INITIAL`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `INITIAL`=?", 
						new Object[] { uuid, name.getObject1(), new Timestamp(name.getObject2()), new Timestamp(name.getObject2()) }));
			for(DoubleObject<String, Long> nickname : nicknameUpdate)
				updates.add(new DoubleObject<>("INSERT INTO `prev_nicknames` (`UUID`, `NICKNAME`, `INITIAL`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `INITIAL`=?", 
						new Object[] { uuid, nickname.getObject1(), new Timestamp(nickname.getObject2()), new Timestamp(nickname.getObject2()) }));
			for(DoubleObject<InetAddress, Long> ip : ipUpdate)
				updates.add(new DoubleObject<>("INSERT INTO `prev_ips` (`UUID`, `IP`, `INITIAL`) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE `INITIAL`=?", 
						new Object[] { uuid, ip.getObject1().getHostAddress(), new Timestamp(ip.getObject2()), new Timestamp(ip.getObject2()) }));
			db.multiUpdate(updates);
		}
		
	}
	
	/**
	 * Gets the player history from the database for that player.
	 * 
	 * Should be run async.
	 * @param p the Player to get the history of.
	 * @return the PlayerHistory of the given player.
	 */
	public static PlayerHistory getPlayerHistory(BasePlayer p) {
		UUID u = p.getUniqueId();
		Set<DoubleObject<String, Long>> nameHistory = new HashSet<>();
		Set<DoubleObject<InetAddress, Long>> ipHistory = new HashSet<>();
		Set<DoubleObject<String, Long>> nicknameHistory = new HashSet<>();
		Map<DoubleObject<String, Object[]>, Consumer<ResultSet>> queryMap = new HashMap<>();
		queryMap.put(
				new DoubleObject<>("SELECT `NAME`, `INITIAL` FROM `prev_names` WHERE `UUID`=? ORDER BY `INITIAL` DESC", new Object[] { u }),
				rs -> {
					try {
						while(rs.next())
							nameHistory.add(new DoubleObject<>(rs.getString(1), rs.getTimestamp(2).getTime()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				);
		queryMap.put(
				new DoubleObject<>("SELECT `IP`, `INITIAL` FROM `prev_ips` WHERE `UUID`=? ORDER BY `INITIAL` DESC", new Object[] { u }),
				rs -> {
					try {
						while(rs.next())
							ipHistory.add(new DoubleObject<>(InetAddress.getByName(rs.getString(1)), rs.getTimestamp(2).getTime()));
					} catch (SQLException | UnknownHostException e) {
						e.printStackTrace();
					}
				}
				);
		queryMap.put(
				new DoubleObject<>("SELECT `NICKNAME`, `INITIAL` FROM `prev_nicknames` WHERE `UUID`=? ORDER BY `INITIAL` DESC", new Object[] { u }),
				rs -> {
					try {
						while(rs.next())
							nicknameHistory.add(new DoubleObject<>(rs.getString(1), rs.getTimestamp(2).getTime()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				);
		db.multiQuery(queryMap);
		return new PlayerHistory(u, nameHistory, ipHistory, nicknameHistory);
	}
	
}
