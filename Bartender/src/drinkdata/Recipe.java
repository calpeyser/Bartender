package drinkdata;

import java.util.Map;
import java.util.TreeMap;

class Recipe {

	private String name;
	private Map<Ingredient, Integer> parts;
	
	public Recipe(RecipeBuilder builder) {
		this.name = builder.getName();
		this.parts = builder.getParts();
	}	
}
