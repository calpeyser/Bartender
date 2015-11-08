package simplebartender;

import hardware.HardwareCapabilities;
import control.State;
import control.StateChangeEvent;
import control.StateManager;
import drinkdata.MockRecipeProvider;
import drinkdata.RecipeProvider;

public class SimpleStateManager extends StateManager {

	private State landingState;
	private State drinkMenuState;
	
	public SimpleStateManager(HardwareCapabilities hardwareCapabilites, RecipeProvider recipeProvider) {
		this.landingState = new LandingState(hardwareCapabilites);
		this.drinkMenuState = new DrinkMenuState(hardwareCapabilites, recipeProvider);
	}
	
	@Override
	public State getFirstState() {
		return null;
	}

	@Override
	public State changeState(StateChangeEvent stateChangeEvent) {
		// TODO Auto-generated method stub
		return null;
	}

}
