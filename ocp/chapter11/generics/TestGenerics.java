import java.util.*;

class GenericClass<T> {
	T anInstance;
	T[] anArayOfTs;
	
	GenericClass(T anInstance) {
		this.anInstance = anInstance;
	}
	
	T getT() {
		return anInstance;
	}
}

class GenericPair<X, Y> {
	X first;
	Y second;
	
	GenericPair(X first, Y second) {
		this.first = first;
		this.second = second;
	}
	
	X getFirst() {
		return first;
	}
	
	Y getSecond() {
		return second;
	}
	
	public String toString() {
		return "[" + first + ", " + second + "]";
	}
}


interface Animal {
	void checkup();
}

class AnimalHolder<T extends Animal> {
	T animal;
	AnimalHolder(T animal) {
		this.animal = animal;
	}
}

class GenericPairHolder<X, Y, T extends GenericPair<X, Y>> {
	T pair;
	
	GenericPairHolder(T pair) {
		this.pair = pair;
	}
}

public class TestGenerics {
	public static void main(String[] args) {
		GenericClass<String> gc = new GenericClass<>("Hello world!");
		String text = gc.getT();
		System.out.println(text);
		
		GenericPair<Integer, String> pair = 
				new GenericPair<>(15, "I am second!");
		System.out.println(pair);
		
		GenericPairHolder<Integer, String, 
			GenericPair<Integer, String>> holder = 
				new GenericPairHolder<>(pair);
	}
}
