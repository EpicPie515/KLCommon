package lol.kangaroo.common.player;

import java.util.Set;
import java.util.UUID;

import lol.kangaroo.common.player.punish.IPunishManager;
import lol.kangaroo.common.player.punish.Punishment;

public abstract class BasePlayer {
	
	protected UUID uuid;
	protected IPlayerVariableManager pvm;
	protected IPunishManager pm;
	
	protected BasePlayer(UUID uuid, IPlayerVariableManager pvm, IPunishManager pm) {
		this.uuid = uuid;
		this.pvm = pvm;
		this.pm = pm;
	}
	
	public UUID getUniqueId() {
		return uuid;
	}
	
	public abstract Object getVariable(PlayerVariable pv);

	public abstract Set<Punishment> getActivePunishments();
	public abstract Set<Punishment> getPunishments();
	
}
