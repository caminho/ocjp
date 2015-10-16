import java.util.*;

public class SearchingArray {
	
	static Comparator<String> STRING_REVERSE_ORDER =
		new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
	
	public static void main(String[] args) {
		String[] arr = {"one", "two", "three", "four"};
		Arrays.sort(arr);
		
		System.out.println(Arrays.asList(arr));
		System.out.println("one: " + Arrays.binarySearch(arr, "one"));
		
		Arrays.sort(arr, STRING_REVERSE_ORDER);
		
		System.out.println(Arrays.asList(arr));
		System.out.println("one: " + Arrays.binarySearch(arr, "one"));
		System.out.println("one: " + Arrays.binarySearch(arr, "one",
			STRING_REVERSE_ORDER));
	}
}