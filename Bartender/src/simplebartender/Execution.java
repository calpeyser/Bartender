package simplebartender;

import hardware.HardwareCapabilities;
import hardware.HardwareConfig;
import hardware.HardwarePrimitiveActions;
import control.BartenderController;
import control.StateManager;
import drinkdata.MockRecipeProvider;
import drinkdata.RecipeProvider;

public class Execution {
	
	public static void main(String[] args) {
		
		RecipeProvider recipeProvider = new MockRecipeProvider();
		HardwareConfig hardwareConfig = new MockHardwareConfig(recipeProvider);
		HardwarePrimitiveActions hardwarePrimitiveActions = new MockHardwarePrimitiveActions();
		CanisterConfigFactory canisterConfigFactory = new MockCanisterConfigFactory();
		HardwareCapabilities hardwareCapabilties = new PumpsetHardwareCapabilities(hardwarePrimitiveActions, hardwareConfig, canisterConfigFactory);
		StateManager stateManager = new SimpleStateManager(hardwareCapabilties, recipeProvider);
		BartenderController controller = new BartenderController(stateManager);
		
	}
}
