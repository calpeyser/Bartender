package simplebartender;

import java.util.Map;

import drinkdata.Ingredient;
import drinkdata.Recipe;
import hardware.HardwareCapabilities;
import hardware.HardwareConfig;
import hardware.HardwarePrimitiveActions;

public class PumpsetHardwareCapabilities extends HardwareCapabilities {

	private CanisterConfig canisterConfig;
	
	public PumpsetHardwareCapabilities(
			HardwarePrimitiveActions hardwarePrimitiveActions,
			HardwareConfig hardwareConfig,
			CanisterConfigFactory canisterConfigFactory) {
		super(hardwarePrimitiveActions, hardwareConfig);
		this.canisterConfig = canisterConfigFactory.getCanisterConfig();
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
		hardwarePrimitiveActions.dispense(canisterConfig.canisterOf(ingredient), amount);
	}
}
