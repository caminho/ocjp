class Animal {
	static void doStuff() {
		System.out.println("a");
	}
}

class Dog extends Animal {
	static void doStuff() {
		System.out.println("d");
	}
}

public class StaticTest {
	public static void main(String[] args) {
		Animal[] a = new Animal[] { 
			new Animal(),
			new Dog(),
			new Animal(),
			null
		};
		
		for (int x = 0; x < a.length; x++) {
			a[x].doStuff(); // kompilator zamieni to na Animal.doStuff()
		}
		
		Dog.doStuff();
	}
}
