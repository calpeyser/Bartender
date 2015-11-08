package simplebartender;

import java.util.Map;

import drinkdata.Ingredient;
import drinkdata.Recipe;
import hardware.HardwareCapabilities;
import hardware.HardwareConfig;
import hardware.HardwarePrimitiveActions;

public class RotatingHardwareCapabilities extends HardwareCapabilities {

	public RotatingHardwareCapabilities(
			HardwarePrimitiveActions hardwarePrimitiveActions,
			HardwareConfig hardwareConfig) {
		super(hardwarePrimitiveActions, hardwareConfig);
	}

	@Override
	public void writeToDisplay(String message) {
		hardwarePrimitiveActions.writeToDisplay(message);
	}

	@Override
	public void makeRecipe(Recipe recipe) {
		Map<Ingredient, Integer> parts = recipe.getParts();
		for (Ingredient ingredient : parts.keySet()) {
			dispenseIngredient(ingredient, parts.get(ingredient));
		}
	}
	
	private void dispenseIngredient(Ingredient ingredient, int amount) {
		rotateToIngredient(ingredient);
		hardwarePrimitiveActions.dispense(amount);
	}
	
	private void rotateToIngredient(Ingredient ingredient) {
		int canisterNumber = hardwareConfig.canisterOfIngredient(ingredient);
		rotateToCanister(canisterNumber);
	}
	
	private void rotateToCanister(int canisterNumber) {
		int degrees = (360/hardwareConfig.numberOfCanisters()) * canisterNumber;
		hardwarePrimitiveActions.rotateServo(degrees);
	}

}
