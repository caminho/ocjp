import java.util.*;

class Dog {
	String name;
	Dog(String n) {
		name = n;
	}
}

public class IteratorTest {
	public static void main(String[] args) {
		List<Dog> dogs = new ArrayList<>();
		
		Dog dog = new Dog("aiko");
		dogs.add(dog);
		dogs.add(new Dog("clover"));
		dogs.add(new Dog("magnolia"));
		
		//Iterator it = dogs.iterator();
		Iterator<Dog> it = dogs.iterator();
		System.out.println(it.getClass());
		while (it.hasNext()) {
			//Dog d = (Dog) it.next();
			Dog d = it.next();
			System.out.println(d.name);
		}
		System.out.println("size: " + dogs.size());
		System.out.println("dogs[1]: " + dogs.get(1).name);
		System.out.println("aiko: " + dogs.indexOf(dog));
		dogs.remove(2);
		Object[] oa = dogs.toArray();
		for (Object o: oa) {
			Dog d2 = (Dog) o;
			System.out.println("oa " + d2.name);
		}
	}
}