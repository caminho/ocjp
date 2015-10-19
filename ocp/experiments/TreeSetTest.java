import java.util.*;

class Dog {}

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<String> s = new TreeSet<String>();
		TreeSet<String> subs = new TreeSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		subs = (TreeSet<String>) s.subSet("b", true, "d", true);
		if (subs instanceof TreeSet) {
			System.out.println("subs is TreeSet");
		}
		System.out.println(s);
		System.out.println(subs);
		s.add("g");
		s.pollFirst();
		s.pollFirst();
		s.add("c2");
		System.out.println("-----------");
		System.out.println(s);
		System.out.println(subs);
		System.out.println("-----------");
		
		TreeSet<Dog> dogs = new TreeSet<Dog>();
		//dogs.add(new Dog()); // ZLE - Dog to nie Comparable
		//dogs.add(new Dog());
		System.out.println(dogs);
	}
}