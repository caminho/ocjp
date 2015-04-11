class Animal {
	String name;
	Animal(String name) {
		this.name = name;
	}
	
	Animal() {
		this(makeRandomName());
	}
	
	static String makeRandomName() {
		int x = (int) (Math.random()*5);
		String name = new String[] {"Fluffy", "Fido",
		"Rover", "Spike", "Gigi"}[x];
		return name;
	}
}

public class Overloading {
	
	public static void main(String[] args) {
		Animal a = new Animal();
		System.out.println(a.name);

		Animal b = new Animal("Zeus");
		System.out.println(b.name);
	}
}
