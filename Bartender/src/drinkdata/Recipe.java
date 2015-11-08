package drinkdata;

import java.util.Map;
import java.util.TreeMap;

public class Recipe {

	private String name;
	private Map<Ingredient, Integer> parts;
	
	public Recipe(RecipeBuilder builder) {
		this.name = builder.getName();
		this.parts = builder.getParts();
	}	
	
	public String getName() {
		return name;
	}
	
	public Map<Ingredient, Integer> getParts() {
		return parts;
	}
}
