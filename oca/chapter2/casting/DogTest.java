interface Animatable {
	public void animate();
}

class Animal {
	public void animate() {
		System.out.println("animating animal");
	}
}
class Dog extends Animal implements Animatable {}

public class DogTest {
	public static void main(String[] args) {
		Animal animal = new Animal();
		//Dog dog = (Dog) animal;  // run time error
		
		Dog d = new Dog();
		Animal a1 = d;
		Animal a2 = (Animal) d;
		
		((Animatable)d).animate();
	}
}
