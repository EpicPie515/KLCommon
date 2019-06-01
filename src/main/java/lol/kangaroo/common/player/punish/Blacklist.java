package lol.kangaroo.common.player.punish;

import java.util.UUID;

public class Blacklist extends Punishment {

	public Blacklist(UUID uuid, long timestamp, String reason, UUID author, String unReason, long unTimestamp, UUID unAuthor, int server,
			boolean active) {
		super(uuid, timestamp, -1, reason, author, unReason, server, unAuthor, server, active);
	}
	
}
