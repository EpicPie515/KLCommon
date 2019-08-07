package lol.kangaroo.common.util;

import java.time.Duration;
import java.util.Locale;

public class DurationFormat {
	
	/**
	 * Includes years, days, hours, minutes.
	 * @param past If true will append the translation of "ago" to the formatted string.
	 */
	public static String getFormattedDuration(Duration dur, Locale lang, boolean past) {
		long days = dur.toDays();
		long years = ((days - (days % 365)) / 365);
		dur = dur.minusDays(days);
		days = days % 365;
		long hours = dur.toHours();
		dur = dur.minusHours(hours);
		long minutes = dur.toMinutes();
		String ds = "";
		if(years == 0 && days == 0 && hours == 0 && minutes == 0)
			ds = MSG.TIMEFORMAT_LESSTHANMIN.getMessage(lang);
		else {
			if(years > 0) ds += years + " " + MSG.TIMEFORMAT_YEARS.getMessage(lang) + ", ";
			if(days > 0) ds += days + " " + MSG.TIMEFORMAT_DAYS.getMessage(lang) + ", ";
			if(hours > 0) ds += hours + " " + MSG.TIMEFORMAT_HOURS.getMessage(lang) + ", ";
			ds += minutes + " " + MSG.TIMEFORMAT_MINUTES.getMessage(lang);
		}
		if(past) ds += " " + MSG.TIMEFORMAT_PAST.getMessage(lang);
		return ds;
	}
	
}
