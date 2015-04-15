class Collar {}

class Dog {
	Collar c;				// zmienna instancji
	String name;			// zmienna instancji
	
	void go(Dog dog) { 		// zmienna lokalna: dog
		c = new Collar();
		dog.setName("Aiko");
	}
	
	void setName(String dogName) {	// zmienna lokalna: dogName
		name = dogName;
		// do more stufff
	}
}

public class StackAndHeap {
	public static void main(String[] args) {
		Dog d;				// zmienna lokalna
		d = new Dog();
		d.go(d);
	}
}
