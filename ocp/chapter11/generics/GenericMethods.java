import java.util.*;

public class GenericMethods {
	
	public static <T extends Number> List<T> createNumberList(T number) {
		List<T> list = new ArrayList<>();
		list.add(number);
		return list;
	}
	
	public static <T> List<T> createArrayList(T element) {
		List<T> list = new ArrayList<T>();
		//for (T t: elements) {
			list.add(element);
		//}
		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> list = createArrayList(2);
		System.out.println(list);
		System.out.println(createArrayList("Hello world!"));
	}
}