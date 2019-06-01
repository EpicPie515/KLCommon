package lol.kangaroo.common.player;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface IPlayerVariableManager {

	public Object getPlayerVariable(UUID uuid, PlayerVariable v);
	
	/**
	 * WARNING: This method should be run asynchronously.
	 * @param v Set of types of Player Variables to get.
	 * @return Map of those variables.
	 */
	public Map<PlayerVariable, Object> getAllPlayerVariables(UUID uuid, Set<PlayerVariable> variables);
	
	public void setPlayerVariable(UUID uuid, PlayerVariable v, Object value);
	
	/**
	 * WARNING: This method should be run asynchronously.
	 * @param v Set of types of Player Variables to set.
	 * @return Map of those variables.
	 */
	public void setAllPlayerVariables(UUID uuid, Map<PlayerVariable, Object> variables);
	
}
