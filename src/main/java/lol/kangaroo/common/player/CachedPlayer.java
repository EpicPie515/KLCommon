package lol.kangaroo.common.player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import lol.kangaroo.common.player.punish.PunishManager;
import lol.kangaroo.common.player.punish.Punishment;

public class CachedPlayer extends BasePlayer {
	
	private Map<PlayerVariable, Object> variables = new HashMap<>();

	private Set<Punishment> punishments = new HashSet<>();
	private Set<Punishment> activePunishments = new HashSet<>();
	
	public CachedPlayer(UUID uuid, Map<PlayerVariable, Object> variables, Set<Punishment> punishments, Set<Punishment> activePunishments, PlayerVariableManager pvm, PunishManager pm) {
		super(uuid, pvm, pm);
		this.variables.putAll(variables);
		this.punishments.addAll(punishments);
		this.activePunishments.addAll(activePunishments);
	}
	
	public Object getVariable(PlayerVariable pv) {
		return variables.get(pv);
	}
	
	public PlayerUpdateCache createUpdateCache() {
		return new PlayerUpdateCache(this, pvm);
	}
	
	/**
	 * Updates the player cache with the new value, then adds the change to the UpdateCache.
	 */
	public void setVariableInUpdate(PlayerUpdateCache u, PlayerVariable pv, Object obj) {
		variables.put(pv, obj);
		u.addToCache(pv, obj);
	}
	
	/**
	 * Gets the full map of variables.
	 * @return Map of PlayerVariables.
	 */
	public Map<PlayerVariable, Object> getAllVariablesMap() {
		return variables;
	}
	
	/**
	 * WARNING: Only use by a Cache Manager, where ALL variables are explicitly set in the new map.
	 * 
	 * Clears the old variables and puts all new ones into the map.
	 * @param map the new variable map.
	 */
	public void setAllVariablesMap(Map<PlayerVariable, Object> map) {
		variables.putAll(map);
	}

	@Override
	public Set<Punishment> getActivePunishments() {
		return activePunishments;
	}

	@Override
	public Set<Punishment> getPunishments() {
		return punishments;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CachedPlayer))
			return false;
		CachedPlayer cp = (CachedPlayer) obj;
		return uuid == cp.uuid;
	}
	
	
	
}
