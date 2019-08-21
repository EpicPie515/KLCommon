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
	public static final MSG PREFIX_LOLCHEAT = new MSG("prefix_lolcheat");
	
	public static final MSG NO_PERM = new MSG("no_perm");
	public static final MSG PLAYER_NOTFOUND = new MSG("player_notfound");
	public static final MSG PLAYER_OFFLINE = new MSG("player_offline");
	public static final MSG UNKNOWN_COMMAND = new MSG("unknown_command");
	public static final MSG MUST_BE_PLAYER = new MSG("must_be_player");
	public static final MSG CONSOLE = new MSG("console");
	
	/** Bonus Amount */
	public static final MSG DAILY_BONUS = new MSG("daily_bonus");
	/** Site Name, Streak **/
	public static final MSG VOTE_RECEIVED = new MSG("vote_received");
	
	/** Rank Name, Duration */
	public static final MSG PLAYER_GRANTEDRANK = new MSG("player_grantedrank");
	/** Rank Name, Reason */
	public static final MSG PLAYER_REMOVEDRANK = new MSG("player_removedrank");
	/** Permission Name (Pref. all caps) */
	public static final MSG PLAYER_GRANTEDPERM = new MSG("player_grantedperm");
	/** Permission Name (Pref. all caps), Reason (short) */
	public static final MSG PLAYER_REMOVEDPERM = new MSG("player_removedperm");
	
	public static final MSG PLAYER_REMOVEDEXPIRED = new MSG("player_removedexpired");

	/** Amount, Multiplier Message **/
	public static final MSG EXP_ADDED = new MSG("exp_added");
	/** Level Color, Level Number, Level Name **/
	public static final MSG EXP_LEVELGAINED = new MSG("exp_levelgained");
	/** Level Color, New Level, Level Number, Level Symbol **/
	public static final MSG EXP_LEVELUP = new MSG("exp_levelup");
	
	/** Amount, Multiplier Message **/
	public static final MSG MONEY_ADDED = new MSG("money_added");

	/** (Formatted pref.) Server **/
	public static final MSG PLAYER_SERVER_CONNECTING = new MSG("player_server_connecting");
	/** (Formatted pref.) Server **/
	public static final MSG PLAYER_SERVER_CONNECTED_ALREADY = new MSG("player_server_connected_already");
	
	public static final MSG TIMEFORMAT_YEARS = new MSG("timeformat_years");
	public static final MSG TIMEFORMAT_DAYS = new MSG("timeformat_days");
	public static final MSG TIMEFORMAT_HOURS = new MSG("timeformat_hours");
	public static final MSG TIMEFORMAT_MINUTES = new MSG("timeformat_minutes");
	public static final MSG TIMEFORMAT_LESSTHANMIN = new MSG("timeformat_lessthanmin");
	public static final MSG TIMEFORMAT_PAST = new MSG("timeformat_past");
	public static final MSG TIMEFORMAT_PERMANENT = new MSG("timeformat_permanent");
	public static final MSG TIMEFORMAT_INVALID = new MSG("timeformat_invalid");
	
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

	public static final MSG UNMUTEMESSAGE_EXPIRED = new MSG("unmutemessage_expired");
	/** Author, Reason **/
	public static final MSG UNMUTEMESSAGE_MANUAL = new MSG("unmutemessage_manual");
	
	
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

	public static final MSG PUBLIC_GAMEBANALERT = new MSG("public_gamebanalert");
	
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

	public static final MSG ADMIN_AUTH_REQUIRED = new MSG("admin_auth_required");
	public static final MSG ADMIN_AUTH_FAIL = new MSG("admin_auth_fail");
	
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

	/** Command, Target **/
	public static final MSG COMMAND_LINKS_SENDER = new MSG("command_links_sender");

	/** Sender **/
	public static final MSG COMMAND_LINKS_ALL_OTHER = new MSG("command_links_all_other");
	public static final MSG COMMAND_LINKS_ALL_SELF = new MSG("command_links_all_self");
	public static final MSG COMMAND_LINKS_ALL = new MSG("command_links_all");
	/** Sender **/
	public static final MSG COMMAND_LINKS_TS_OTHER = new MSG("command_links_ts_other");
	public static final MSG COMMAND_LINKS_TS_SELF = new MSG("command_links_ts_self");
	public static final MSG COMMAND_LINKS_TS = new MSG("command_links_ts");
	/** Sender **/
	public static final MSG COMMAND_LINKS_DISCORD_OTHER = new MSG("command_links_discord_other");
	public static final MSG COMMAND_LINKS_DISCORD_SELF = new MSG("command_links_discord_self");
	public static final MSG COMMAND_LINKS_DISCORD = new MSG("command_links_discord");
	/** Sender **/
	public static final MSG COMMAND_LINKS_WEBSITE_OTHER = new MSG("command_links_website_other");
	public static final MSG COMMAND_LINKS_WEBSITE_SELF = new MSG("command_links_website_self");
	public static final MSG COMMAND_LINKS_WEBSITE = new MSG("command_links_website");
	/** Sender **/
	public static final MSG COMMAND_LINKS_STORE_OTHER = new MSG("command_links_store_other");
	public static final MSG COMMAND_LINKS_STORE_SELF = new MSG("command_links_store_self");
	public static final MSG COMMAND_LINKS_STORE = new MSG("command_links_store");
	/** Sender **/
	public static final MSG COMMAND_LINKS_VOTE_OTHER = new MSG("command_links_vote_other");
	public static final MSG COMMAND_LINKS_VOTE_SELF = new MSG("command_links_vote_self");
	/** Last Vote, Time Left(Or Blank), Current Streak, Expired(Or Blank) **/
	public static final MSG COMMAND_LINKS_VOTE = new MSG("command_links_vote");
	/** 1Unit Time **/
	public static final MSG COMMAND_LINKS_VOTE_TIMELEFT = new MSG("command_links_vote_timeleft");
	public static final MSG COMMAND_LINKS_VOTE_EXPIRED = new MSG("command_links_vote_expired");
	
	/** Formatted Server Name, Internal Server Name **/
	public static final MSG COMMAND_SERVER_CURRENT = new MSG("command_server_current");
	public static final MSG COMMAND_SERVER_UNKNOWN = new MSG("command_server_unknown");
	
	// TODO make the player count in pullall exclude the current server
	public static final MSG COMMAND_PULL_USAGE = new MSG("command_pull_usage");
	/** Player, Server **/
	public static final MSG COMMAND_PULL_ALREADYTHERE = new MSG("command_pull_alreadythere");
	/** Player Count, Server, Command **/
	public static final MSG COMMAND_PULL_ALL_CONFIRM = new MSG("command_pull_all_confirm");
	/** Player Count, Server **/
	public static final MSG COMMAND_PULL_ALL = new MSG("command_pull_all");
	/** Player, Server **/
	public static final MSG COMMAND_PULL_PULL = new MSG("command_pull_pull");
	/** Server, Sender **/
	public static final MSG COMMAND_PULL_PULLED = new MSG("command_pull_pulled");
	/** Server **/
	public static final MSG COMMAND_PULL_PULLED_SILENT = new MSG("command_pull_pulled_silent");
	
	public static final MSG COMMAND_GOTO_USAGE = new MSG("command_goto_usage");
	/** Player **/
	public static final MSG COMMAND_GOTO_FINDING = new MSG("command_goto_finding");
	/** Player, Server **/
	public static final MSG COMMAND_GOTO_FOUND = new MSG("command_goto_found");
	
	/** Attempted Hub, Current Hub **/
	public static final MSG COMMAND_HUB_UNAVAILABLE_STAYING = new MSG("command_hub_unavailable_staying");
	/** Attempted Hub, New Hub **/
	public static final MSG COMMAND_HUB_UNAVAILABLE_CONNECTING = new MSG("command_hub_unavailable_connecting");
	
	public static final MSG COMMAND_ADMIN_USAGE = new MSG("command_admin_usage");
	public static final MSG COMMAND_ADMIN_CMDLIST = new MSG("command_admin_cmdlist");
	
	public static final MSG COMMAND_ADMIN_TESTVOTE_USAGE = new MSG("command_admin_testvote_usage");
	/** Player **/
	public static final MSG COMMAND_ADMIN_TESTVOTE = new MSG("command_admin_testvote");

	public static final MSG COMMAND_ADMIN_PLAYERINFO_USAGE = new MSG("command_admin_playerinfo_usage");
	/** Player, Rank Title, Last Seen **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO = new MSG("command_admin_playerinfo");
	/** Vote Streak, Last Vote, Visibility, Nicknamed, First Join, Level, Experience, Required Experience, Balance, Language **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO_DATA = new MSG("command_admin_playerinfo_data");
	/** Status, Reason, Author, Date **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO_PUNISHED = new MSG("command_admin_playerinfo_punished");
	/** Duration, Time Remaining **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO_TEMPPUNISHED = new MSG("command_admin_playerinfo_temppunished");

	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_VISIBLE = new MSG("command_admin_playerinfo_status_visible");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_VANISHED = new MSG("command_admin_playerinfo_status_vanished");
	/** Server Name **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_ONLINE = new MSG("command_admin_playerinfo_status_online");
	/** Server Name **/
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_ONLINE_WARNING = new MSG("command_admin_playerinfo_status_online_warning");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_UNNICKED = new MSG("command_admin_playerinfo_status_unnicked");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_NICKED = new MSG("command_admin_playerinfo_status_nicked");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_PERMBANNED = new MSG("command_admin_playerinfo_status_permbanned");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_TEMPBANNED = new MSG("command_admin_playerinfo_status_tempbanned");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_BLACKLISTED = new MSG("command_admin_playerinfo_status_blacklisted");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_PERMMUTED = new MSG("command_admin_playerinfo_status_permmuted");
	public static final MSG COMMAND_ADMIN_PLAYERINFO_STATUS_TEMPMUTED = new MSG("command_admin_playerinfo_status_tempmuted");
	
	public static final MSG COMMAND_ADMIN_GRANT_USAGE = new MSG("command_admin_grant_usage");
	/** Argument Name **/
	public static final MSG COMMAND_ADMIN_GRANT_INVALIDARG = new MSG("command_admin_grant_invalidarg");
	public static final MSG COMMAND_ADMIN_GRANT_RANKORPERMREQ = new MSG("command_admin_grant_rankorpermreq");
	public static final MSG COMMAND_ADMIN_GRANT_PERMREQVALUE = new MSG("command_admin_grant_permreqvalue");
	public static final MSG COMMAND_ADMIN_GRANT_TIMEREQ = new MSG("command_admin_grant_timereq");
	/** Argument Name **/
	public static final MSG COMMAND_ADMIN_GRANT_DUPLICATEARG = new MSG("command_admin_grant_duplicatearg");
	/** Player, Rank, Duration **/
	public static final MSG COMMAND_ADMIN_GRANT_RANK_SUCCESS = new MSG("command_admin_grant_rank_success");
	/** Player, Permission, Duration **/
	public static final MSG COMMAND_ADMIN_GRANT_PERM_SUCCESS = new MSG("command_admin_grant_perm_success");

	public static final MSG COMMAND_ADMIN_GENAUTH_USAGE = new MSG("command_admin_genauth_usage");
	/** Player, Rank **/
	public static final MSG COMMAND_ADMIN_GENAUTH_NOTSTAFF = new MSG("command_admin_genauth_notstaff");
	/** Secret **/
	public static final MSG COMMAND_ADMIN_GENAUTH = new MSG("command_admin_genauth");
	public static final MSG COMMAND_ADMIN_GENAUTH_OTHER_ALREADY = new MSG("command_admin_genauth_other_already");
	/** Player **/
	public static final MSG COMMAND_ADMIN_GENAUTH_OTHER = new MSG("command_admin_genauth_other");
	
	
	private String messageKey;
	public MSG(String messageKey) {
		this.messageKey = messageKey;
	}
	
	/**
	 * Returns the formatted message for the given Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * if a @MSG object is any of the arguments, it will automatically be localized.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(String languageCode, Object... args) {
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				if(args[i] instanceof MSG) {
					MSG msgArg = (MSG) args[i];
					args[i] = msgArg.getMessage(languageCode);
				}
			}
		}
		return String.format(color(i18n.getLocalizedMessage(languageCode, this.messageKey)), args);
	}
	
	/**
	 * Returns the formatted message for the given Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * if a @MSG object is any of the arguments, it will automatically be localized.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(Locale locale, Object... args) {
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				if(args[i] instanceof MSG) {
					MSG msgArg = (MSG) args[i];
					args[i] = msgArg.getMessage(locale);
				}
			}
		}
		return String.format(color(i18n.getLocalizedMessage(locale, this.messageKey)), args);
	}
	
	/**
	 * Returns the formatted message for the given Player's Locale.
	 * 
	 * Formatted with String.format and ChatColor translation.
	 * if a @MSG object is any of the arguments, it will automatically be localized.
	 * 
	 * @param args the arguments to the String.format() call.
	 * @return A colored, formatted message.
	 */
	public String getMessage(BasePlayer p, Object... args) {
		String languageCode = (String) p.getVariable(PlayerVariable.LANGUAGE);
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				if(args[i] instanceof MSG) {
					MSG msgArg = (MSG) args[i];
					args[i] = msgArg.getMessage(languageCode);
				}
			}
		}
		return String.format(color(i18n.getLocalizedMessage(languageCode, this.messageKey)), args);
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
		return getInternetTranslation(toTranslate, I18N.getLocale(targetLanguageCode));
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
		return I18N.getLocale(languageCode);
	}
	
}
