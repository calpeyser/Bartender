package hardware;

import drinkdata.Recipe;

public abstract class HardwareCapabilities {
	
	protected HardwarePrimitiveActions hardwarePrimitiveActions;
	protected HardwareConfig hardwareConfig;
	
	public HardwareCapabilities(HardwarePrimitiveActions hardwarePrimitiveActions, HardwareConfig hardwareConfig) {
		this.hardwarePrimitiveActions = hardwarePrimitiveActions;
		this.hardwareConfig = hardwareConfig;
	}
	
	/*
	 * Writes the given message to some form of output.
	 */
	public abstract void writeToDisplay(String message);
	
	/*
	 * Mixes a drink.
	 */
	public abstract void makeRecipe(Recipe recipe);	
}
