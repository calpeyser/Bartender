package drinkdata;

public class Ingredient {

	private String name;
	
	public Ingredient(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Ingredient other = (Ingredient) obj;
		if (this.name.equals(other.name)) {
			return true;
		} else {
			return false;
		}
	}
}
