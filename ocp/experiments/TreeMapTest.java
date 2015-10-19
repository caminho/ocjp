import java.util.*;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<String, String> myMap = new TreeMap<>();
		myMap.put("a", "aaa");
		myMap.put("d", "ddd");
		myMap.put("f", "fff");
		myMap.put("p", "ppp");
		System.out.println(myMap.higherKey("f"));
		System.out.println(myMap.ceilingKey("f"));
		System.out.println(myMap.floorKey("f"));
		
		SortedMap<String, String> sub = myMap.tailMap("f");
		System.out.println(sub.firstKey());
	}
}