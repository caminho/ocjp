class Animal {
	public void eat() {
		System.out.println("Generic Animal Eating Generically!");
	}
}

class Horse extends Animal {
	public void eat() {
		System.out.println("Horse eating!");
	}
	
	void test() {
		super.eat();
	}
	
	public void buck() {}
}

public class TestAnimals {
	public static void main(String[] args) {
		Animal a = new Animal();
		Animal b = new Horse();
		a.eat();
		b.eat();
	}
}
