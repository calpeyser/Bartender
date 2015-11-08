package drinkdata;

import java.util.Map;
import java.util.TreeMap;

public class RecipeBuilder {
		
	private String name;
	private Map<Ingredient, Integer> parts;
	
	public RecipeBuilder(String name) {
		this.name = name;
		this.parts = new TreeMap<Ingredient, Integer>();
	}
	
	public void addPart(Ingredient ingredient, int value) {
		parts.put(ingredient, value);
	}
	
	public String getName() {
		return name;
	}
	
	public Map<Ingredient, Integer> getParts() {
		return parts;
	}
	
	public Recipe build() {
		return new Recipe(this);
	}		
}	

