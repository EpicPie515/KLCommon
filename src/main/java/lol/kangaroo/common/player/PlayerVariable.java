package lol.kangaroo.common.player;

import java.net.InetAddress;
import java.sql.Timestamp;

import lol.kangaroo.common.permissions.Rank;
import net.md_5.bungee.api.ChatColor;

public enum PlayerVariable {
	
	
	
	USERNAME(String.class, "cur_data", "NAME", "valueOf", Object.class),
	IP(InetAddress.class, "cur_data", "IP", "getByName", String.class, "getHostAddress"),
	RANK(Rank.class, "", "", "getByName", String.class),
	PREFIX_C1(ChatColor.class, "", "", "valueOf", String.class, "name"),
	PREFIX_C2(ChatColor.class, "", "", "valueOf", String.class, "name"),
	FAKERANK_DATA(String.class, "", "", "valueOf", Object.class),
	LEVEL(Integer.class),
	EXPERIENCE(Long.class),
	NETWORK_BALANCE(Long.class, "network_money", "BALANCE"),
	FIRSTJOIN(Timestamp.class, "join_data"),
	LASTQUIT(Timestamp.class, "join_data"),
	LASTJOIN(Timestamp.class, "join_data"),
	ADMIN_ALERT(Boolean.class),
	LANGUAGE(String.class, "", "", "valueOf", Object.class),
	NICKNAME(String.class, "", "", "valueOf", Object.class),
	VOTE_STREAK(Integer.class),
	VOTE_LAST(Timestamp.class),
	RANK_EXPIRETIME(Timestamp.class),
	RANK_EXPIRETO(Rank.class, "", "", "getByName", String.class),
	
	/** Make sure to update defaults in @PlayerManager#createNewPlayer */
	
	; // this semicolon ends the enum, don't touch.
	
	private Class<?> clazz;
	private String dbTable;
	private String dbColumn;
	private String valueOf;
	private Class<?> valueOfArg;
	private String toString;
	
	PlayerVariable(Class<?> clazz) {
		this.clazz = clazz;
		this.dbTable = "player_data";
		this.dbColumn = name().toLowerCase();
		this.valueOf = "valueOf";
		this.valueOfArg = String.class;
		this.toString = "toString";
	}
	
	PlayerVariable(Class<?> clazz, String dbTable) {
		this.clazz = clazz;
		this.dbTable = dbTable;
		this.dbColumn = name();
		this.valueOf = "valueOf";
		this.valueOfArg = String.class;
		this.toString = "toString";
	}
	
	PlayerVariable(Class<?> clazz, String dbTable, String dbColumn) {
		this.clazz = clazz;
		if(dbTable.equals(""))
			this.dbTable = "player_data";
		else
			this.dbTable = dbTable;
		this.dbColumn = dbColumn;
		this.valueOf = "valueOf";
		this.valueOfArg = String.class;
		this.toString = "toString";
	}
	
	PlayerVariable(Class<?> clazz, String dbTable, String dbColumn, String valueOf, Class<?> valueOfArg) {
		this.clazz = clazz;
		if(dbTable.equals(""))
			this.dbTable = "player_data";
		else
			this.dbTable = dbTable;
		if(dbColumn.equals(""))
			this.dbColumn = name().toLowerCase();
		else
			this.dbColumn = dbColumn;
		this.valueOf = valueOf;
		this.valueOfArg = valueOfArg;
		this.toString = "toString";
	}
	
	PlayerVariable(Class<?> clazz, String dbTable, String dbColumn, String valueOf, Class<?> valueOfArg, String toString) {
		this.clazz = clazz;
		if(dbTable.equals(""))
			this.dbTable = "player_data";
		else
			this.dbTable = dbTable;
		if(dbColumn.equals(""))
			this.dbColumn = name().toLowerCase();
		else
			this.dbColumn = dbColumn;
		this.valueOf = valueOf;
		this.valueOfArg = valueOfArg;
		this.toString = toString;
	}
	
	public String getDBTable() {
		return dbTable;
	}
	
	public String getDBColumn() {
		return dbColumn;
	}
	
	public Class<?> getVariableClass() {
		return clazz;
	}
	
	public String getValueOfMethod() {
		return valueOf;
	}
	
	public Class<?> getValueOfArg() {
		return valueOfArg;
	}
	
	public String getToStringMethod() {
		return toString;
	}
	
}
