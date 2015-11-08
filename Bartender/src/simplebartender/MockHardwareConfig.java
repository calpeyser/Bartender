package simplebartender;

import java.util.ArrayList;
import java.util.List;

import drinkdata.Ingredient;
import drinkdata.RecipeProvider;
import hardware.HardwareConfig;

public class MockHardwareConfig implements HardwareConfig {
	
	private List<Ingredient> ingredientByCanister;
	
	public MockHardwareConfig(RecipeProvider recipeProvider) {
		this.ingredientByCanister = new ArrayList<Ingredient>();
		ingredientByCanister.add(recipeProvider.getIngredient("Ingredient 1"));
		ingredientByCanister.add(recipeProvider.getIngredient("Ingredient 2"));
		ingredientByCanister.add(recipeProvider.getIngredient("Ingredient 3"));
		ingredientByCanister.add(recipeProvider.getIngredient("Ingredient 4"));
		ingredientByCanister.add(recipeProvider.getIngredient("Ingredient 5"));		
	}
	
	@Override
	public int numberOfCanisters() {
		return 5;
	}

	@Override
	public Ingredient ingredientInCanister(int canisterNumber) {
		return ingredientByCanister.get(canisterNumber);
	}

	@Override
	public int canisterOfIngredient(Ingredient ingredient) {
		for(int i = 0; i < ingredientByCanister.size(); i++) {
			if (ingredientByCanister.get(i) == ingredient) {
				return i;
			}
		}
		throw new RuntimeException("Could not find ingredient " + ingredient + " in hardware");
	}
}
