package lol.kangaroo.common.permissions;

import java.util.UUID;

import lol.kangaroo.common.player.BasePlayer;

public interface IRankManager {
	
	/**
	 * Gets the prefix of the player with the given UUID.
	 * 
	 * This method will always get the prefix from the <b>cache</b>.
	 * 
	 * This will return PLAYER Rank's prefix if the UUID has never joined.
	 * 
	 * @param uuid UUID of the player to get the prefix of.
	 * @return the Formatted prefix for the player with the given UUID.
	 */
	public String getPrefix(UUID uuid);
	
	/**
	 * Gets the Prefix directly from the database. Not Recommended,
	 * but useful for cases that the prefix needs to be the most recent updated.
	 * 
	 * This will return PLAYER Rank's prefix if the UUID has never joined.
	 * 
	 * @param uuid UUID of the player
	 * @return the Prefix of the player with the given UUID, from the database, non-cached.
	 */
	public String getPrefixDirect(UUID uuid);
	
	/**
	 * Gets the prefix of the player.
	 * 
	 * This is the formatted, colored prefix.
	 * If the rank has a formatted prefix, the player's color settings will be formatted in,
	 * otherwise it will return the rank's specified prefix.
	 * 
	 * This will use the data storage of the player object passed,
	 * so if it is a CachedPlayer it will use the cache,
	 * and if it is a DatabasePlayer it will use the database.
	 * @param pl the Player to get the prefix of.
	 * @return The formatted prefix of that player.
	 */
	public String getPrefix(BasePlayer pl);
	
	/**
	 * Gets the Rank from the cached player.
	 * 
	 * Unlike the other methods, this will always return the <b>cached</b> rank.
	 * 
	 * This will return PLAYER Rank if the UUID has never joined.
	 * 
	 * @param uuid
	 * @return
	 */
	public Rank getRank(UUID uuid);
	
	/**
	 * Gets the Rank from the player object.
	 * 
	 * If the BasePlayer is an instance of CachedPlayer it will get the cached rank,
	 * if it is a DatabasePlayer it will get the database rank, like {@link #getRankDirect(UUID)}
	 * @param pl the Player.
	 * @return the Rank from the player.
	 */
	public Rank getRank(BasePlayer pl);
	
	/**
	 * Gets the Rank directly from the database. Not Recommended,
	 * but useful for cases that the rank needs to be the most recent updated.
	 * 
	 * This will return PLAYER Rank if the UUID has never joined.
	 * 
	 * @param uuid UUID of the player
	 * @return the Rank from the database, non-cached.
	 */
	public Rank getRankDirect(UUID uuid);
	
	
	
}
