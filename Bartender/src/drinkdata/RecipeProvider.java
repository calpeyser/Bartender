package drinkdata;

import java.util.List;

public interface RecipeProvider {

	public List<Ingredient> ingredients();
	
	public List<Recipe> recipes();
	
	public Ingredient getIngredient(String ingredientName);
}
