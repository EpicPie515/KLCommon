package lol.kangaroo.common.permissions;

import java.time.Instant;
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
	 * Unlike the other methods, this will always return the <b>cached</b> rank, unless their rank is not in the cache.
	 * 
	 * This will return PLAYER Rank if the UUID has never joined.
	 * 
	 * @param uuid
	 * @param useModifiedRank specifies whether modifications to the player's rank setting should be included. This includes their nickname-rank or their fake-rank settings.
	 * @return
	 */
	public Rank getRank(UUID uuid, boolean useModifiedRank);
	
	/**
	 * Gets the Rank from the player object.
	 * 
	 * If the BasePlayer is an instance of CachedPlayer it will get the cached rank,
	 * if it is a DatabasePlayer it will get the database rank, like {@link #getRankDirect(UUID)}
	 * @param pl the Player.
	 * @param useModifiedRank specifies whether modifications to the player's rank setting should be included. This includes their nickname-rank or their fake-rank settings.
	 * @return the Rank from the player.
	 */
	public Rank getRank(BasePlayer pl, boolean useModifiedRank);
	
	/**
	 * Gets the Rank directly from the database. Not Recommended,
	 * but useful for cases that the rank needs to be the most recent updated.
	 * 
	 * This will return PLAYER Rank if the UUID has never joined.
	 * 
	 * @param uuid UUID of the player
	 * @param useModifiedRank specifies whether modifications to the player's rank setting should be included. This includes their nickname-rank or their fake-rank settings.
	 * @return the Rank from the database, non-cached.
	 */
	public Rank getRankDirect(UUID uuid, boolean useModifiedRank);

	/**
	 * Gets the Expiry Timestamp of their Rank.
	 * 
	 * Unlike the other methods, this will always return the <b>cached</b> rank expiry, unless their rank expiry is not in the cache.
	 * 
	 * This will return <b>null</b> if the rank is permanent.
	 * 
	 * @param uuid UUID of the player
	 * @return the Rank expiry instant for that player, or null if it doesn't expire.
	 */
	public Instant getRankExpiry(UUID uuid);
	
	/**
	 * Gets the Expiry Timestamp of their Rank.
	 * 
	 * If the BasePlayer is an instance of CachedPlayer it will get the cached rank expiry,
	 * if it is a DatabasePlayer it will get the database rank expiry, like {@link #getRankDirect(UUID)}
	 * 
	 * This will return <b>null</b> if the rank is permanent.
	 * 
	 * @param pl the player
	 * @return the Rank expiry instant for that player, or null if it doesn't expire.
	 */
	public Instant getRankExpiry(BasePlayer pl);
	
	/**
	 * Gets the Rank to give this player when their current rank expires.
	 * 
	 * This will always return from the cache unless it is not in the cache.
	 * 
	 * Defaults to PLAYER, however may be altered for staff or rank upgrades from permanent ranks to monthly subscriptions. (e.g. Hypixel's MVP+ to MVP++)
	 * @param uuid UUID of the player
	 * @return the Rank to give to the player when theirs expires.
	 */
	public Rank getRankExprireTo(UUID uuid);
	
	/**
	 * Gets the Rank to give this player when their current rank expires.
	 * 
	 * This will return either cached or direct, depending on the player implementation.
	 * 
	 * Defaults to PLAYER, however may be altered for staff or rank upgrades from permanent ranks to monthly subscriptions. (e.g. Hypixel's MVP+ to MVP++)
	 * 
	 * @param pl the player
	 * @return the Rank to give to the player when theirs expires.
	 */
	public Rank getRankExprireTo(BasePlayer pl);
	
}
