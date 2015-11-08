package hardware;

import drinkdata.Ingredient;

public interface HardwareConfig {

	public int numberOfCanisters();
	
	public Ingredient ingredientInCanister(int canisterNumber);
	
	public int canisterOfIngredient(Ingredient ingredient);
	
}
