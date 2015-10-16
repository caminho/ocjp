import java.util.*;

public class ArrayToList {
	public static void main(String[] args) {
		String[] sa = {"one", "two", "three", "four"};
		
		List<String> list = Arrays.asList(sa);
		System.out.println("size: " + list.size());
		System.out.println("list[2]: " + list.get(2));
		
		list.set(3, "six");
		sa[1] = "five";
		
		for (String s: sa) {
			System.out.print(s + " ");
		}
		System.out.println("\nlista[1]: " + list.get(1));
	}
}
