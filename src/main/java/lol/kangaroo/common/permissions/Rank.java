package lol.kangaroo.common.permissions;

import net.md_5.bungee.api.ChatColor;

public enum Rank {
	
	PLAYER(10, 1, 99, ChatColor.GRAY, "Player", "Player", "kmc.player", ChatColor.GRAY + "", false),
	OG(14, 2, 95, ChatColor.GRAY, "OG", "OG", "kmc.plus", ChatColor.LIGHT_PURPLE + "%1$s[" + ChatColor.GRAY + "OG" + ChatColor.LIGHT_PURPLE + "%1$s]" + ChatColor.GRAY + " ", true),
	FAKERANK(12, 2, 14, ChatColor.BLUE, "Admin*", "Admin", "kmc.plus"),
	PLUS(20, 2, 90, ChatColor.WHITE, "Plus", "Plus", "kmc.plus", ChatColor.WHITE + "[+] ", false),
	PREMIUM(40, 4, 80, ChatColor.GOLD, "Premium", "kmc.premium"),
	YT(44, 4, 75, ChatColor.RED, "YT", "kmc.yt"),
	ULTRA(50, 5, 70, ChatColor.DARK_AQUA, "Ultra", "kmc.ultra"),
	RETIRED_STAFF(60, 5, 65, ChatColor.DARK_AQUA, "Retired Staff", "RetStaff", "kmc.retiredstaff", "[ULTRA] ", false),
	KANGAROO(62, 6, 60, ChatColor.LIGHT_PURPLE, "Kangaroo", "Kangaroo", "kmc.kangaroo",  ChatColor.LIGHT_PURPLE + "%1$s[" + ChatColor.LIGHT_PURPLE + "KANGAROO%1$s]" + ChatColor.LIGHT_PURPLE + " ", true),
	KANGAROOPLUS(64, 7, 55, ChatColor.LIGHT_PURPLE, "Kangaroo+", "Kangaroo+", "kmc.kangarooplus",  ChatColor.LIGHT_PURPLE + "%1$s[" + ChatColor.LIGHT_PURPLE + "KANGAROO" + ChatColor.DARK_PURPLE + "%2$s+" + ChatColor.LIGHT_PURPLE + "%1$s]" + ChatColor.LIGHT_PURPLE + " ", true),
	YOUTUBE(65, 7, 45, ChatColor.DARK_RED, "YouTube", "Youtube", "kmc.youtube", ChatColor.LIGHT_PURPLE + "%1$s[" + ChatColor.DARK_RED + "YOU" + ChatColor.WHITE + "TUBE" + ChatColor.LIGHT_PURPLE + "%1$s]" + ChatColor.DARK_RED + " ", true),
	OGKANGAROO(67, 7, 41, ChatColor.LIGHT_PURPLE, "Kangaroo+ OG", "Kangaroo+", "kmc.kangarooplus", ChatColor.LIGHT_PURPLE + "%1$s[" + ChatColor.BLUE + "KANGAROO" + ChatColor.LIGHT_PURPLE + "+%1$s]" + ChatColor.LIGHT_PURPLE + "%2$s ", true),
	ORIGINAL_FOUNDER(68, 7, 38, ChatColor.YELLOW, "Original Founder", "Founder", "kmc.founder"),
	JRMOD(70, 8, 35, ChatColor.AQUA, "Junior Moderator", "JrMod", "kmc.jrmod"),
	MOD(80, 9, 30, ChatColor.DARK_GREEN, "Moderator", "Mod", "kmc.mod"),
	SRMOD(100, 10, 20, ChatColor.GREEN, "Senior Moderator", "SrMod", "kmc.srmod"),
	ADMIN_DEV(120, 11, 10, ChatColor.DARK_PURPLE, "Administrator / Developer", "Admin", "kmc.admin"),
	ADMIN_CR(130, 11, 5, ChatColor.DARK_PURPLE, "Administrator / Community Relations", "Admin", "kmc.admin"),
	ADMIN_SRDEV(120, 12, 10, ChatColor.DARK_PURPLE, "Administrator / Senior Developer", "Admin", "kmc.admin"),
	OWNER(140, 13, 1, ChatColor.DARK_PURPLE, "Administrator / Owner", "Owner", "kmc.owner");
	
	private int id;
	private int level;
	private ChatColor color;
	private String name;
	private String shortName;
	private String perm;
	private String prefix;
	private int sbw;
	private boolean prefixFormatted;
	Rank(int id, int level, int sbw, ChatColor color, String name, String perm) {
		this(id, level, sbw, color, name, name, perm);
	}
	
	Rank(int id, int level, int sbw, ChatColor color, String name, String shortName, String perm) {
		this(id, level, sbw, color, name, shortName, perm, "[" + shortName.toUpperCase() + "] ", false);
	}

	Rank(int id, int level, int sbw, ChatColor color, String name, String shortName, String perm, String prefix, boolean prefixFormatted) {
		this.id = id;
		this.level = level;
		this.color = color;
		this.name = name;
		this.shortName = shortName;
		this.perm = perm;
		this.prefix = prefix;
		this.sbw = sbw;
		this.prefixFormatted = prefixFormatted;
	}
		
	/**
	 * Gets the ID of the rank. No other rank has the same ID. Lower IDs are lower on the ladder.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the level of the rank. A number that will be the same for some ranks of equal value. Use ID for a differing number.
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Rank is considered staff with a level of 8(ATM) or higher.
	 * @return true if that rank is Staff, false otherwise.
	 */
	public boolean isStaff() {
		return level >= Rank.JRMOD.getLevel();
	}
	
	/**
	 * Rank is considered senior staff with a level of 10(ATM) or higher.
	 * @return true if that rank is Senior Staff, false otherwise.
	 */
	public boolean isSrStaff() {
		return level >= Rank.SRMOD.getLevel();
	}
	
	/**
	 * Specifies if this Rank has formatting in its prefix.
	 * @return whether the prefix contains formatting or not.
	 */
	public boolean isPrefixFormatted() {
		return prefixFormatted;
	}

	/**
	 * @return the main (name)color of the rank.
	 */
	public ChatColor getColor() {
		return color;
	}

	/**
	 * @return the name of the rank.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the shortened name, used for prefixes or references to the general rank title, less specific.
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @return the permission given to players of this rank.
	 */
	public String getPerm() {
		return perm;
	}
	
	/**
	 * 
	 * @return the number that precedes the scoreboard team to sort the tab list properly.
	 */
	public int getSbWeight() {
		return sbw;
	}
	
	/**
	 * Use a localized rank manager to get the formatted prefix, not this.
	 * @return the raw prefix
	 */
	public String getRawPrefix() {
		return prefix;
	}
	
	/**
	 * Gets the rank by ID only.
	 * @param id of the rank.
	 * @return Rank object with that id.
	 */
	public static Rank getById(int id) {
		for(Rank r : values())
			if(r.getId() == id) return r;
		return null;
	}
	
	/**
	 * Finds a rank with that name string, enum name, prefix, or id
	 * Multiple ranks with same prefix or shortName exist, so using those is not recommended.
	 * @param name
	 * @return
	 */
	public static Rank getByName(String name) {
		for(Rank r : values())
			if(r.name().equalsIgnoreCase(name) || r.getName().equalsIgnoreCase(name) || r.getShortName().equalsIgnoreCase(name) || name.equals(r.getId() + "") || ChatColor.stripColor(r.getRawPrefix()).equalsIgnoreCase(ChatColor.stripColor(name))) return r;
		return null;
	}
	
}
