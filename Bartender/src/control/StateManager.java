package control;

import drinkdata.RecipeProvider;
import hardware.HardwareCapabilities;

public abstract class StateManager {
	
	public abstract State getFirstState();
	
	public abstract State changeState(StateChangeEvent stateChangeEvent);
	
}
