package simplebartender;

import java.util.Map;

import drinkdata.Ingredient;

public final class CanisterConfig {

	private Map<Ingredient, Integer> canisters; 
	private int numberOfCanisters;
	
	public CanisterConfig(Map<Ingredient, Integer> canisters, int numberOfCanisters) {
		this.canisters = canisters;
		this.numberOfCanisters = numberOfCanisters;
	}
	
	public int canisterOf(Ingredient ingredient) throws IllegalArgumentException {
		if (!canisters.containsKey(ingredient)) {
			throw new IllegalArgumentException("CanisterConfig does not have ingredient " + ingredient); 
		}
		else {
			return canisters.get(ingredient);
		}
	}
	
	public int getNumberOfCanisters() {
		return this.numberOfCanisters;
	}
}
