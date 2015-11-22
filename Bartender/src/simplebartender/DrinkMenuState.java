package simplebartender;

import java.util.List;

import hardware.HardwareCapabilities;
import hardware.HardwareEvent;
import control.RelinquishException;
import control.State;
import control.StateChangeEvent;
import drinkdata.RecipeProvider;
import drinkdata.Recipe;

/*
 * Provides a cycleable drink menu.  Left and right buttons move through the list,
 * enter makes the drink, and back returns to the landing state.
 */
public class DrinkMenuState extends State {
	
	private List<Recipe> recipes;
	private int recipeIndex;
	
	public DrinkMenuState(HardwareCapabilities hardwareCapabilites, RecipeProvider recipeProvider) {
		super(hardwareCapabilites);
		this.recipes = recipeProvider.recipes();
		this.recipeIndex = 0;
	}
		
	@Override
	public void handleEntry() {
		displayCurrentRecipeName();
	}
	
	@Override
	public void handleEventByState(HardwareEvent event)
			throws RelinquishException {
		switch (event) {
		case ButtonLeft:
			handleButtonLeft();
			break;
		case ButtonRight:
			handleButtonRight();
			break;
		case ButtonEnter:
			handleButtonEnter();
			break;
		case ButtonBack:
			handleButtonBack();
			break;
		}
	}
	
	private void handleButtonLeft() {
		decrementRecipeIndex();
		displayCurrentRecipeName();
	}
	
	private void handleButtonRight() {
		incrementRecipeIndex();
		displayCurrentRecipeName();
	}
	
	private void handleButtonEnter() {
		hardwareCapabilities.makeRecipe(recipes.get(recipeIndex));
	}
	
	private void handleButtonBack() throws RelinquishException {
		throw new RelinquishException(new StateChangeEvent("Landing Page", SimpleStateChangeEvent.ToLandingPage));
	}
	
	private void displayCurrentRecipeName() {
		hardwareCapabilities.writeToDisplay(recipes.get(recipeIndex).getName());		
	}
	
	private void decrementRecipeIndex() {
		if (recipeIndex == 0) {
			recipeIndex = recipes.size() - 1;
		} else {
			recipeIndex--;
		}
	}
	
	private void incrementRecipeIndex() {
		if (recipeIndex == recipes.size() - 1) {
			recipeIndex = 0;
		} else {
			recipeIndex++;
		}
	}
}
