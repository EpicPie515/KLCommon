package lol.kangaroo.common.player;

import java.util.HashMap;
import java.util.Map;

public class PlayerUpdateCache {
	
	private PlayerVariableManager pvm;
	
	private CachedPlayer cp;
	private Map<PlayerVariable, Object> updateVariables = new HashMap<>();
	
	PlayerUpdateCache(CachedPlayer cp, PlayerVariableManager pvm) {
		this.cp = cp;
		this.pvm = pvm;
	}
	
	void addToCache(PlayerVariable pv, Object obj) {
		updateVariables.put(pv, obj);
	}
	
	void removeFromCache(PlayerVariable pv) {
		updateVariables.remove(pv);
	}
	
	/**
	 * Send the updated variables to the database.
	 */
	public void pushUpdates() {
		pvm.setAllPlayerVariables(cp.getUniqueId(), updateVariables);
	}
	
}
