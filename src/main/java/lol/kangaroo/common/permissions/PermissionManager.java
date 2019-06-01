package lol.kangaroo.common.permissions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
	
	// TODO add setters
	
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
