import java.util.*;

public class AutoboxingTest {
	public static void main(String[] args) {
		List myInts = new ArrayList();
		myInts.add(new Integer(42));  // dodawanie do listy przed Java 5
		myInts.add(23); // autoboxing - 23 zostanie zamienione na Integer
		System.out.println(myInts);
		
		Integer y = new Integer(12); // zwiekszenie o 1 przed Java 5
		int x = y.intValue();
		x++;
		y = new Integer(x);
		System.out.println("y = " + y);
		
		y = new Integer(567); // zwiekszenie o 1 z autoboxingiem
		y++;
		System.out.println("y = " + y);
	}
}
