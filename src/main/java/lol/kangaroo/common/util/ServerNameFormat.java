package lol.kangaroo.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerNameFormat {
	
	private static final Pattern pat = Pattern.compile("^([a-z]{3})([0-9]+)([a-z]?)$");
	
	public static String format(String server) {
		Matcher m = pat.matcher(server);
		if(!m.matches())
			throw new RuntimeException("Non-standard server name tried to be formatted: " + server);
		String sn = m.group(1);
		int num = Integer.parseInt(m.group(2));
		String mod = m.group(3);
		String fin = sn.toUpperCase() + "-" + num + (!mod.isEmpty() ? " [" + mod.toUpperCase() + "]" : "");
		return fin;
	}
	
}
