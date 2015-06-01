import java.util.*;

public class ArrayListTest {
	public static void addToList(List list) {
		list.add("0067");
	}

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>(10);
		addToList(lst);
		System.out.println(lst.get(0));
		((ArrayList<Integer>)lst).trimToSize();
	}
}

