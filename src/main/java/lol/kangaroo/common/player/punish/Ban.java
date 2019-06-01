package lol.kangaroo.common.player.punish;

import java.util.UUID;

public class Ban extends Punishment {

	public Ban(UUID uuid, long timestamp, long duration, String reason, UUID author, String unReason, long unTimestamp, UUID unAuthor, int server,
			boolean active) {
		super(uuid, timestamp, duration, reason, author, unReason, server, unAuthor, server, active);
	}
	
}
