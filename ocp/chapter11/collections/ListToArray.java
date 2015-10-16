import java.util.*;

public class ListToArray {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", "three", "four");
		
		Object[] objArray = list.toArray();
		System.out.println(Arrays.toString(objArray));
		
		String[] strArray = {};
		strArray = list.toArray(strArray);
		
		System.out.println(Arrays.toString(strArray));
	}
}