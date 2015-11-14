import java.util.*;


public class ArrayListTest {
	//public static void addToList(List list) {
	//	list.add("0067");
	//}

	public static void main(String[] args) {
		//List<Integer> lst = new ArrayList<Integer>(10);
		//addToList(lst);
		//System.out.println(lst.get(0));
		//((ArrayList<Integer>)lst).trimToSize();
		
		ArrayList<Double> al = new ArrayList<>();
		al.add(42.0);
		
		
		System.out.println(al.contains("string"));
		System.out.println(al.contains(42));
		System.out.println(al.contains(42.0));
		
		
		System.out.println(al.indexOf("string"));
		System.out.println(al.indexOf(42));
		System.out.println(al.indexOf(42.0));
		
	}
}

