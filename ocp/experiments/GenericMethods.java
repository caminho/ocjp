import java.util.*;

class One<E> {
	<T> One(T elem) {
		System.out.println(elem);
	}
}

public class GenericMethods {
	public static <T> List<T> createEmptyList() {
		return new ArrayList<T>();
	}
	
	public <T> List<T> makeEmptyList() {
		return new ArrayList<T>();
	}
	
	public static void processList(List<String> list) {
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		
		List<String> list = GenericMethods.<String>createEmptyList();
		// List<String> list = <String>createEmptyList(); //ZLE
		list.add("hello");
		list.add("world:)");
		System.out.println(list);
		
		List<Number> list2 = createEmptyList();
		list2.add(2);
		list2.add(2.2);
		System.out.println(list2);
		
		GenericMethods gm = new GenericMethods();
		
		List<Double> list3 = gm.createEmptyList();
		list3.add(2.4);
		list3.add(2.2);
		System.out.println(list3);
		
		// Nie jest potrzebne <Double> przed nazwa metody, kompilator
		// wstawi typ Double sam
		//List<? super Double> list4 = gm.<Double>createEmptyList();
		List<? super Double> list4 = gm.createEmptyList();
		list4.add(2.4);
		list4.add(2.2);
		System.out.println(list3);
		
		One<String> one = new <Integer>One<String>(3);
		One<String> one2 = new One<String>(3);
		One<String> two = new <Double>One<String>(3.3);
		//One<String> two2 = new <Double>One<>(3.3); // ZLE

		// processList(createEmptyList()); // ZLE - w javie7 nie przejdzie
		processList(GenericMethods.<String>createEmptyList()); // poprawnie
		
	}
}
