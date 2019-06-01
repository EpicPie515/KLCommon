package lol.kangaroo.common.player.punish;

import java.net.InetAddress;
import java.util.Set;
import java.util.UUID;

public interface IPunishManager {

	/**
	 * Gets all punishments from the logs for the player.
	 */
	public Set<Punishment> getPunishments(UUID uuid);
	
	/**
	 * Gets all active punishments from the logs for that player.
	 */
	public Set<Punishment> getActivePunishments(UUID uuid);
	
	/**
	 * Gets all active blacklists for that IP.
	 * 
	 * This is ordered with the newest first.
	 */
	public Set<Blacklist> getActiveBlacklists(InetAddress ip);

	/**
	 * Checks if the player is punished in any way. (Banned, Kicked, Muted or Blacklisted)
	 * @returns true if any of their punishments are active.
	 */
	public boolean isPunished(UUID uuid);

	/**
	 * Checks if the player is banned.
	 * @returns true if any of their bans are active.
	 */
	public boolean isBanned(UUID uuid);
	
	/**
	 * Checks if the player is blacklisted.
	 * @returns true if any of their blacklists are active.
	 */
	public boolean isBlacklisted(UUID uuid);
	

	/**
	 * Checks if the IP is blacklisted.
	 * @returns true if any of the IPs associated blacklists are active.
	 */
	public boolean isBlacklisted(InetAddress ip);
	
	/**
	 * Checks if the player is muted.
	 * @returns true if any of their mutes are active.
	 */
	public boolean isMuted(UUID uuid);

	/**
	 * Checks if the player is permanently banned.
	 * @returns true if any of their bans are active and permanent.
	 */
	public boolean isPermanentlyBanned(UUID uuid);
	
	/**
	 * Checks if the player is temporarily banned.
	 * @returns true if any of their bans are active and non-permanent.
	 */
	public boolean isTemporarilyBanned(UUID uuid);
	
	/**
	 * Checks if the player is permanently muted.
	 * @returns true if any of their mutes are active and permanent.
	 */
	public boolean isPermanentlyMuted(UUID uuid);

	/**
	 * Checks if the player is temporarily muted.
	 * @returns true if any of their mutes are active and non-permanent.
	 */
	public boolean isTemporarilyMuted(UUID uuid);
	
	/**
	 * Executes the ban and returns the Ban object.
	 * 
	 * Returns null if the UUID is already banned.
	 * 
	 * @param ban the Ban to execute.
	 */
	public Ban executeBan(UUID target, long duration, UUID author, String reason, int server);
	
	/**
	 * Executes an unban on the given Ban object and returns the Ban object.
	 * 
	 * @param ban the Ban to reverse.
	 */
	public Ban executeUnBan(Ban ban, String unReason, UUID unAuthor);
	
	/**
	 * Executes the blacklist and returns the Blacklist object.
	 * 
	 * Returns null if the UUID is already blacklisted.
	 * 
	 * @param blacklist the Blacklist to execute.
	 */
	public Blacklist executeBlacklist(UUID target, UUID author, String reason, int server);
	
	/**
	 * Executes an unblacklist on the given Blacklist object and returns the Blacklist object.
	 * 
	 * @param blacklist the Blacklist to reverse.
	 */
	public Blacklist executeUnBlacklist(Blacklist blacklist, String unReason, UUID unAuthor);
	
	/**
	 * Executes the mute and returns the Mute object.
	 * 
	 * Returns null if the UUID is already muted.
	 * 
	 * @param mute the Mute to execute.
	 */
	public Mute executeMute(UUID target, long duration, UUID author, String reason, int server);
	
	/**
	 * Executes an unmute on the given Mute object and returns the Mute object.
	 * 
	 * @param mute the Mute to reverse.
	 */
	public Mute executeUnMute(Mute mute, String unReason, UUID unAuthor);
	
	/**
	 * Executes a kick on the target if they are online, otherwise no Kick will be issued and this will return null.
	 */
	public Kick executeKick(UUID target, UUID author, String reason, int server);


	
}
