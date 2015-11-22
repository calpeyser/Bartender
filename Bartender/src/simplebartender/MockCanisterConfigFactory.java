package simplebartender;

import java.util.HashMap;
import java.util.Map;

import drinkdata.Ingredient;

public class MockCanisterConfigFactory extends CanisterConfigFactory {

	@Override
	public CanisterConfig getCanisterConfig() {
		Map<Ingredient, Integer> canisters = new HashMap<Ingredient, Integer>();
		canisters.put(new Ingredient("Ingredient 1"), 1);
		canisters.put(new Ingredient("Ingredient 2"), 2);
		canisters.put(new Ingredient("Ingredient 3"), 3);
		canisters.put(new Ingredient("Ingredient 4"), 4);
		canisters.put(new Ingredient("Ingredient 5"), 5);
		
		return new CanisterConfig(canisters, 5);
	}
}
