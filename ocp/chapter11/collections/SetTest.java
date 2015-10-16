import java.util.*;

public class SetTest {
	
	void goWithoutGeneric() {
		
		boolean[] ba = new boolean[5];
		
		Set set = new HashSet();
		// Set set = new TreeSet();
		
		ba[0] = set.add("a");
		ba[1] = set.add(new Integer(42));
		ba[2] = set.add("b");
		ba[3] = set.add("a");
		ba[4] = set.add(new Object());
		
		for (boolean b: ba) {
			System.out.print(b + " ");
		}
		System.out.println();
		for (Object o: set) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
	
	void goWithGeneric() {
		Set<String> set = new TreeSet<String>();
		System.out.print(set.add("a") + " ");
		System.out.print(set.add("d") + " ");
		System.out.print(set.add("c") + " ");
		// System.out.print(set.add(new Integer(3)) + " "); // ZLE
		System.out.print(set.add("a") + " ");
		System.out.print(set.add("b") + " ");
		System.out.println();
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest();
		st.goWithoutGeneric();
		st.goWithGeneric();
	}
}