package lol.kangaroo.common.player.punish;

import java.util.UUID;

public class Kick extends Punishment {

	public Kick(UUID uuid, long timestamp, String reason, UUID author, int server) {
		super(uuid, timestamp, -1, reason, author, null, 0, null, server, false);
	}

}
