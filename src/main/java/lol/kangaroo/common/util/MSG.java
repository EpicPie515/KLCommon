package lol.kangaroo.common.util;

import java.util.Locale;

import com.gtranslate.Translator;

import lol.kangaroo.common.player.BasePlayer;
import lol.kangaroo.common.player.PlayerVariable;
import net.md_5.bungee.api.ChatColor;

public class MSG {
	
	private static I18N i18n;
	
	private static Translator translate;
	
	public static void init(I18N i) {
		i18n = i;
		translate = Translator.getInstance();
	}
	
	public static final MSG PREFIX_KL = new MSG("prefix_kl");
	public static final MSG PREFIX_ADMIN = new MSG("prefix_admin");
	public static final MSG PREFIX_STAFFCHAT = new MSG("prefix_staffchat");
	public static final MSG PREFIX_ALERT = new MSG("prefix_alert");
	public static final MSG PREFIX_BROADCAST = new MSG("prefix_broadcast");
	public static final MSG PREFIX_ERROR = new MSG("prefix_error");
	public static final MSG PREFIX_PLAYER = new MSG("prefix_player");
	
	public static final MSG NO_PERM = new MSG("no_perm");
	public static final MSG PLAYER_NOTFOUND = new MSG("player_notfound");
	public static final MSG PLAYER_OFFLINE = new MSG("player_offline");
	public static final MSG UNKNOWN_COMMAND = new MSG("unknown_command");
	public static final MSG CONSOLE = new MSG("console");
	
	/** Bonus Amount */
	public static final MSG DAILY_BONUS = new MSG("daily_bonus");
	/** Site Name, Streak **/
	public static final MSG VOTE_RECEIVED = new MSG("vote_received");
	

	/** Amount, Multiplier Message **/
	public static final MSG EXP_ADDED = new MSG("exp_added");
	/** New Level, Level Number, Level Symbol **/
	public static final MSG EXP_LEVELUP = new MSG("exp_levelup");
	
	/** Amount, Multiplier Message **/
	public static final MSG MONEY_ADDED = new MSG("money_added");

	/** Rank Name, Duration */
	public static final MSG PLAYER_GRANTEDRANK = new MSG("player_grantedrank");
	/** Rank Name, Reason */
	public static final MSG PLAYER_REMOVEDRANK = new MSG("player_removedrank");
	/** Permission Name (Pref. all caps) */
	public static final MSG PLAYER_GRANTEDPERM = new MSG("player_grantedperm");
	/** Permission Name (Pref. all caps) */
	public static final MSG PLAYER_REMOVEDPERM = new MSG("player_removedperm");
	

	public static final MSG TIMEFORMAT_YEARS = new MSG("timeformat_years");
	public static final MSG TIMEFORMAT_DAYS = new MSG("timeformat_days");
	public static final MSG TIMEFORMAT_HOURS = new MSG("timeformat_hours");
	public static final MSG TIMEFORMAT_MINUTES = new MSG("timeformat_minutes");
	public static final MSG TIMEFORMAT_PERMANENT = new MSG("timeformat_permanent");
	
	/** Formatted Time Remeaining */
	public static final MSG BANNED_TIMEREMAINING = new MSG("banned_timeremaining");
	public static final MSG BANNED_TIMEPERMANENT = new MSG("banned_timepermanent");

	public static final MSG PUNISHMESSAGE_HAVEBEEN = new MSG("punishmessage_havebeen");
	public static final MSG PUNISHMESSAGE_ARE = new MSG("punishmessage_are");
	
	/** Line, Have Been/Are, Author, Date, Duration, Reason, Time Remaining, Appeal, Line */
	public static final MSG KICKMESSAGE_BAN = new MSG("kickmessage_ban");
	/** Line, Have Been/Are, Author, Date, Reason, Line */
	public static final MSG KICKMESSAGE_BLACKLIST = new MSG("kickmessage_blacklist");
	/** Line, Author, Date, Reason, Line */
	public static final MSG KICKMESSAGE_BLACKLISTIP = new MSG("kickmessage_blacklistip");
	/** Line, Author, Date, Reason, Support Email, Line */
	public static final MSG KICKMESSAGE_KICK = new MSG("kickmessage_kick");

	/** Have Been/Are, Duration, Author, Reason, Date, Time Remaining, Appeal */
	public static final MSG MUTEMESSAGE_TEMPORARY = new MSG("mutemessage_temporary");
	/** Have Been/Are, Author, Reason, Date, Appeal */
	public static final MSG MUTEMESSAGE_PERMANENT = new MSG("mutemessage_permanent");
	
	public static final MSG APPEAL_URL = new MSG("appeal_url");
	public static final MSG SUPPORT_EMAIL = new MSG("support_email");
	
	public static final MSG BLACKLIST_LINE = new MSG("blacklist_line");
	public static final MSG BANSCREEN_LINE = new MSG("banscreen_line");
	
	/** Target, Author, Reason */
	public static final MSG PUBLIC_KICKALERT = new MSG("public_kickalert");
	/** Target, Author, Reason */
	public static final MSG PUBLIC_BANALERT = new MSG("public_banalert");
	/** Target, Duration, Author, Reason */
	public static final MSG PUBLIC_TEMPBANALERT = new MSG("public_tempbanalert");
	/** Line, Target, Author, Reason, Line */
	public static final MSG PUBLIC_BLACKLISTALERT = new MSG("public_blacklistalert");
	/** Target, Author, Reason */
	public static final MSG PUBLIC_MUTEALERT = new MSG("public_mutealert");
	/** Target, Duration, Author, Reason */
	public static final MSG PUBLIC_TEMPMUTEALERT = new MSG("public_tempmutealert");

	/** Target, Author */
	public static final MSG PUBLIC_UNBANALERT = new MSG("public_unbanalert");
	/** Target, Author */
	public static final MSG PUBLIC_UNMUTEALERT = new MSG("public_unmutealert");
	/** Target, Author */
	public static final MSG PUBLIC_UNBLACKLISTALERT = new MSG("public_unblacklistalert");
	
	/** Player */
	public static final MSG ADMIN_JOINALERT = new MSG("admin_joinalert");
	/** Player */
	public static final MSG ADMIN_LEAVEALERT = new MSG("admin_leavealert");
	/** Player */
	public static final MSG ADMIN_CONLOSTALERT = new MSG("admin_conlostalert");
	/** New Name, Old Name */
	public static final MSG ADMIN_NAMECHANGEALERT = new MSG("admin_namechangealert");
	/** Server, Target, Author, Reason, Silent */
	public static final MSG ADMIN_KICKALERT = new MSG("admin_kickalert");
	/** Server, Target, Duration, Author, Reason, Silent */
	public static final MSG ADMIN_TEMPBANALERT = new MSG("admin_tempbanalert");
	/** Server, Target, Author, Reason, Silent */
	public static final MSG ADMIN_BANALERT = new MSG("admin_banalert");
	/** Target, Author, Reason, Silent */
	public static final MSG ADMIN_BLACKLISTALERT = new MSG("admin_blacklistalert");
	/** Server, Target, Duration, Author, Reason, Silent */
	public static final MSG ADMIN_TEMPMUTEALERT = new MSG("admin_tempmutealert");
	/** Server, Target, Author, Reason, Silent */
	public static final MSG ADMIN_MUTEALERT = new MSG("admin_mutealert");
	/** Target, Author, Reason, Silent */
	public static final MSG ADMIN_UNBANALERT = new MSG("admin_unbanalert");
	/** Target */
	public static final MSG ADMIN_UNBANEXPIREALERT = new MSG("admin_unbanexpirealert");
	/** Target, Author, Reason, Silent */
	public static final MSG ADMIN_UNMUTEALERT = new MSG("admin_unmutealert");
	/** Target */
	public static final MSG ADMIN_UNMUTEEXPIREALERT = new MSG("admin_unmuteexpirealert");
	/** Target, Author, Reason, Silent */
	public static final MSG ADMIN_UNBLACKLISTALERT = new MSG("admin_unblacklistalert");
	
	public static final MSG ADMIN_SILENT = new MSG("admin_silent");
	public static final MSG ADMIN_OFFLINE = new MSG("admin_offline");
	
	public static final MSG COMMAND_BAN_USAGE = new MSG("command_ban_usage");	
	public static final MSG COMMAND_BAN_ALREADY = new MSG("command_ban_already");
	
	public static final MSG COMMAND_MUTE_USAGE = new MSG("command_mute_usage");	
	public static final MSG COMMAND_MUTE_ALREADY = new MSG("command_mute_already");	
	
	public static final MSG COMMAND_BLACKLIST_USAGE = new MSG("command_blacklist_usage");	
	public static final MSG COMMAND_BLACKLIST_ALREADY = new MSG("command_blacklist_already");
	
	public static final MSG COMMAND_UNBAN_USAGE = new MSG("command_unban_usage");	
	public static final MSG COMMAND_UNBAN_ALREADY = new MSG("command_unban_already");
	
	public static final MSG COMMAND_UNMUTE_USAGE = new MSG("command_unmute_usage");	
	public static final MSG COMMAND_UNMUTE_ALREADY = new MSG("command_unmute_already");	
	
	public static final MSG COMMAND_UNBLACKLIST_USAGE = new MSG("command_unblacklist_usage");	
	public static final MSG COMMAND_UNBLACKLIST_ALREADY = new MSG("command_unblacklist_already");

	public static final MSG COMMAND_PING_USAGE = new MSG("command_ping_usage");
	/** Ping **/
	public static final MSG COMMAND_PING_SELF = new MSG("command_ping_self");
	/** Player, Ping **/
	public static final MSG COMMAND_PING_OTHER = new MSG("command_ping_other");
	
	
	private String messageKey;
	public MSG(String messageKey) {
		this.messageKey = messageKey;
	}
	
	/**
	 * Returns the formatted message for the given Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(String languageCode, Object... args) {
		return String.format(color(i18n.getLocalizedMessage(languageCode, this.messageKey)), args);
	}
	
	/**
	 * Returns the formatted message for the given Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(Locale locale, Object... args) {
		return String.format(color(i18n.getLocalizedMessage(locale, this.messageKey)), args);
	}
	
	/**
	 * Returns the formatted message for the given Player's Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(BasePlayer p, Object... args) {
		return String.format(color(i18n.getLocalizedMessage((String) p.getVariable(PlayerVariable.LANGUAGE), this.messageKey)), args);
	}
	
	/**
	 * Returns the unformatted, raw message for the given Locale.
	 * @param languageCode the Locale code.
	 * @return A raw, unformatted message.
	 */
	public String getUnformattedMessage(String languageCode) {
		return i18n.getLocalizedMessage(languageCode, this.messageKey);
	}
	
	/**
	 * Returns the unformatted, raw message for the given Player's Locale.
	 * @param p the Player to get the Locale from.
	 * @return A raw, unformatted message.
	 */
	public String getUnformattedMessage(BasePlayer p) {
		return i18n.getLocalizedMessage((String) p.getVariable(PlayerVariable.LANGUAGE), this.messageKey);
	}
	
	/**
	 * WARNING: This will return the colored, but unformatted message in the DEFAULT Language!
	 * 
	 * DO NOT use this, use {@link #getMessage(String, Object...)} or {@link #getMessage(BasePlayer, Object...)}
	 */
	@Override
	public String toString() {
		return getMessage(Locale.getDefault());
	}
	
	/**
	 * Seriously, why not just use {@link #getMessage(String, Object...)} for this?
	 */
	public String toString(String languageCode, Object... args) {
		return getMessage(languageCode, args);
	}
	
	/**
	 * Seriously, why not just use {@link #getMessage(Locale, Object...)} for this?
	 */
	public String toString(Locale locale, Object... args) {
		return getMessage(locale, args);
	}
	
	/**
	 * Requests a translation from the Internet in the target Locale.
	 * 
	 * Probably should run asynchronous.
	 * 
	 * @param toTranslate the string to be translated.
	 * @param targetLocale the language to be translated into.
	 * @return the translated string.
	 */
	public static String getInternetTranslation(String toTranslate, Locale targetLocale) {
		return translate.translate(toTranslate, Locale.getDefault().getLanguage(), targetLocale.getLanguage());
	}
	
	/**
	 * Requests a translation from the Internet in the target Locale.
	 * @param toTranslate the string to be translated.
	 * @param targetLanguageCode the language code of the language to be translated into.
	 * @return the translated string.
	 */
	public static String getInternetTranslation(String toTranslate, String targetLanguageCode) {
		return getInternetTranslation(toTranslate, i18n.getLocale(targetLanguageCode));
	}
	
	/**
	 * Colors and formats the string, without translation.
	 */
	public static String format(String msg, Object... args) {
		return String.format(color(msg), args);
	}
	
	/**
	 * Colors the string using color codes.
	 */
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	/**
	 * @I18N pass-through method, used to get the Locale from the string-based language code. 
	 * 
	 * Language codes are an ISO 639-1 followed by an underscore then an ISO 3166-1 alpha-2.
	 * 
	 * @param languageCode the string-based language code.
	 * @return Locale of the languageCode
	 */
	public static Locale getLocale(String languageCode) {
		return i18n.getLocale(languageCode);
	}
	
}
