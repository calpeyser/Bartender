package drinkdata;

import java.util.ArrayList;
import java.util.List;

public class MockRecipeProvider implements RecipeProvider {

	private List<Ingredient> ingredients;
	private List<Recipe> recipies;
	
	public MockRecipeProvider() {
		ingredients = makeIngredients();
		recipies = makeRecipes();
	}
	
	@Override
	public List<Ingredient> ingredients() {
		// TODO Auto-generated method stub
		return this.ingredients;
	}

	@Override
	public List<Recipe> recipes() {
		return this.recipies;
	}
	
	public Ingredient getIngredient(String ingredientName) {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getName().equals(ingredientName)) {
				return ingredient;
			}
		}
		throw new RuntimeException("Ingredient " + ingredientName + " not found.");
	}
	
	
	private List<Ingredient> makeIngredients() {
		List<Ingredient> out = new ArrayList<Ingredient>();
		
		out.add(new Ingredient("Ingredient 1"));
		out.add(new Ingredient("Ingredient 2"));
		out.add(new Ingredient("Ingredient 3"));
		out.add(new Ingredient("Ingredient 4"));
		out.add(new Ingredient("Ingredient 5"));
		
		return out;
	}
	
	private List<Recipe> makeRecipes() {
		List<Recipe> out = new ArrayList<Recipe>();
		
		out.add(new RecipeBuilder("Recipe 1")
			.addPart(getIngredient("Ingredient 1"), 1)
			.build()
		);
		out.add(new RecipeBuilder("Recipe 2")
			.addPart(getIngredient("Ingredient 1"), 1)
			.addPart(getIngredient("Ingredient 2"), 2)
			.build()
		);
		
		return out;
	}
}
