package lol.kangaroo.common.database;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import lol.kangaroo.common.util.ObjectMutable;

public enum Setting {

	XPMULTIPLIER(Float.class, "xpmultiplier", 1f),
	COINMULTIPLIER(Float.class, "coinmultiplier", 1f),
	XPMREASON(String.class, "xpm_reason", "", "valueOf", Object.class),
	COINMREASON(String.class, "coinm_reason", "", "valueOf", Object.class),
	NEWSMESSAGE(String.class, "news", "", "valueOf", Object.class),
	MOTDTOP(String.class, "motd_top", "", "valueOf", Object.class),
	MOTDBOTTOM(String.class, "motd_bottom", "", "valueOf", Object.class),
	
	;
	
	private Class<?> clazz;
	private String settingName;
	private Object defValue;
	private String valueOf;
	private Class<?> valueOfArg;
	private String toString;
	
	Setting(Class<?> clazz, String settingName, Object defValue) {
		this(clazz, settingName, defValue, "valueOf", String.class);
	}
	
	Setting(Class<?> clazz, String settingName, Object defValue, String valueOf, Class<?> valueOfArg) {
		this(clazz, settingName, defValue, valueOf, valueOfArg, "toString");
	}
	
	Setting(Class<?> clazz, String settingName, Object defValue, String valueOf, Class<?> valueOfArg, String toString) {
		this.clazz = clazz;
		this.settingName = settingName;
		this.defValue = defValue;
		this.valueOf = valueOf;
		this.valueOfArg = valueOfArg;
		this.toString = toString;
	}
	
	public Class<?> getSettingClass() {
		return clazz;
	}

	public String getSettingName() {
		return settingName;
	}

	public String getValueOf() {
		return valueOf;
	}

	public Class<?> getValueOfArg() {
		return valueOfArg;
	}

	public String getToString() {
		return toString;
	}
	
	public Object getDefaultValue() {
		return defValue;
	}

	private static DatabaseManager db;
	
	public static void init(DatabaseManager dbm) {
		db = dbm;
	}
	
	public static void setSetting(Setting s, Object value) {
		db.update("INSERT INTO `settings` (`SETTING`, `VALUE`) VALUES (?, ?) ON DUPLICATE KEY SET `VALUE`=? WHERE `SETTING`=?", s.getSettingName(), value, value, s.getSettingName());
	}
	
	public static Object getSetting(Setting s) {
		ObjectMutable<String> o = new ObjectMutable<>(null);
		db.query("SELECT `VALUE` FROM `settings` WHERE `SETTING`=?", rs -> {
			try {
				if(rs.next())
					o.set(rs.getString(1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}, s.getSettingName());
		Object rt = o.get();
		if(rt == null) {
			return s.getDefaultValue();
		}
		try {
			Method valueOf = s.getSettingClass().getMethod(s.getValueOf(), s.getValueOfArg());
			rt = valueOf.invoke(null, o.get());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return rt;
	}
	
}
