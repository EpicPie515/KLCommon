package lol.kangaroo.common.player.punish;

import java.util.UUID;

public abstract class Punishment {
	
	private UUID uuid;
	private long timestamp;
	private long duration;
	private String reason;
	private UUID author;
	private String unReason;
	private long unTimestamp;
	private UUID unAuthor;
	private int server;
	private boolean active;
	
	public Punishment(UUID uuid, long timestamp, long duration, String reason, UUID author, String unReason, long unTimestamp, UUID unAuthor, int server,
			boolean active) {
		this.uuid = uuid;
		this.timestamp = timestamp;
		this.duration = duration;
		this.reason = reason;
		this.author = author;
		this.unReason = unReason;
		this.unTimestamp = unTimestamp;
		this.unAuthor = unAuthor;
		this.server = server;
		this.active = active;
	}
	
	public UUID getUniqueId() {
		return uuid;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public long getDuration() {
		return duration;
	}

	public String getReason() {
		return reason;
	}

	public UUID getAuthor() {
		return author;
	}

	public String getUnReason() {
		return unReason;
	}
	
	public long getUnTimestamp() {
		return unTimestamp;
	}
	
	public UUID getUnAuthor() {
		return unAuthor;
	}

	public int getServer() {
		return server;
	}

	public boolean isActive() {
		return active;
	}

	public boolean isPermanent() {
		return duration == -1;
	}
	
	public void setDuration(long duration) {
		this.duration = duration;
	}

	public void setUnReason(String unReason) {
		this.unReason = unReason;
	}

	public void setUnTimestamp(long unTimestamp) {
		this.unTimestamp = unTimestamp;
	}

	public void setUnAuthor(UUID unAuthor) {
		this.unAuthor = unAuthor;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
