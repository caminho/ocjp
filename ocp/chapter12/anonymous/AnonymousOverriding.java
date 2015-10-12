class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

class Food {
	Popcorn popcorn = new Popcorn() {
		public void sizzle() {
			System.out.println("anonymous sizzling popcorn");
		}
		public void pop() {
			System.out.println("anonymous popcorn");
		}
	};
}

public class AnonymousOverriding {
	public static void main(String[] args) {
		Food food = new Food();
		food.popcorn.pop();
		// food.popcorn.sizzle(); // BLAD! sizzle() nie istnieje
		// w klasie Popcorn, wiec nie mozna jej wywolac polimorficznie
		
		new Popcorn() {		
			public void pop() {
				System.out.println("local anonymous popcorn");
			}
		}.pop();
	}
}