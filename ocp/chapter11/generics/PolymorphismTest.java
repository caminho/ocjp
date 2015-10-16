import java.util.*;

interface Animal {
	void checkup();
}

class Dog implements Animal {
	public void checkup() {
		System.out.println("checking dog");
	}
}

class Cat implements Animal {
	public void checkup() {
		System.out.println("checking cat");
	}
}

class Bird implements Animal {
	public void checkup() {
		System.out.println("checking bird");
	}
}

class AnimalDoctor {
	void checkAnimal(Animal animal) {
		animal.checkup();
	}
	
	void checkAnimals(Animal[] animals) {
		for (Animal animal: animals) {
			animal.checkup();
		}
	}
	
	void checkAnimals(List<? extends Animal> animals) {
		for (Animal animal: animals) {
			animal.checkup();
		}
	}
	
	void addAnimal(List<? super Dog> animals) {
		animals.add(new Dog());
	}
}

public class PolymorphismTest {
	
	static void arraysTest() {		
		Dog[] dogs = {new Dog(), new Dog()};
		Cat[] cats = {new Cat(), new Cat(), new Cat()};
		Bird[] birds = {new Bird()};
		
		AnimalDoctor doctor = new AnimalDoctor();
		doctor.checkAnimals(dogs);
		doctor.checkAnimals(cats);
		doctor.checkAnimals(birds);
	}
	
	static void listTest() {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
			
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat());
		cats.add(new Cat());
		cats.add(new Cat());
		
		List<Bird> birds = new ArrayList<Bird>();
		birds.add(new Bird());
		
		AnimalDoctor doctor = new AnimalDoctor();
		doctor.addAnimal(dogs);
		doctor.checkAnimals(dogs);
		doctor.checkAnimals(cats);
		doctor.checkAnimals(birds);
	}
	
	public static void main(String[] args) {
		listTest();
	}
}