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
		landingState.handleEntry();
		return landingState;
	}

	@Override
	public State changeState(StateChangeEvent stateChangeEvent) throws IllegalArgumentException {
		try {
			SimpleStateChangeEvent event = (SimpleStateChangeEvent) stateChangeEvent.getData();
			switch (event) {
			case ToDrinkMenu:
				drinkMenuState.handleEntry();
				return drinkMenuState;
			case ToLandingPage:
				landingState.handleEntry();
				return landingState;
			default:
				throw new IllegalArgumentException();
			}
				
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
