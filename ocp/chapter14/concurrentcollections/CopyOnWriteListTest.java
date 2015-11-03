import java.util.*;
import java.util.concurrent.*;

public class CopyOnWriteListTest {
	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> it = list.iterator();
		System.out.println(it.getClass());
		
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		list.add(0, 2);
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		list.add(2, 33);
		if (it.hasNext()) {
			System.out.println(it.next());
		}
		
		list.add(3, 23);
		if (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}