package lol.kangaroo.common.player;

import java.util.Set;
import java.util.UUID;

import lol.kangaroo.common.player.punish.PunishManager;
import lol.kangaroo.common.player.punish.Punishment;

public abstract class BasePlayer {
	
	protected UUID uuid;
	protected PlayerVariableManager pvm;
	protected PunishManager pm;
	
	protected BasePlayer(UUID uuid, PlayerVariableManager pvm, PunishManager pm) {
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
