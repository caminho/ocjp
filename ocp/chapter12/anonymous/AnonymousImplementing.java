interface Cookable {
	void cook();
}

class Food {
	Cookable cookable = new Cookable() {
		public void cook() {
			System.out.println("Anonymous cookable implementer");
		}
	};
}

public class AnonymousImplementing {
	public static void main(String[] args) {
		Food food = new Food();
		food.cookable.cook();
	}		
}