import java.util.*;

public class Cities {
	public static void main(String[] args) {
		List<String> c = new ArrayList<String>();
		c.add("Oslo");
		c.add("Paris");
		c.add("Rome");
		
		int index = c.indexOf("Paris");
		System.out.println(c + " " + index);
		c.add(index, "London");
		System.out.println(c);
		
		c.add("Warsaw");
		c.add("Warsaw");
		System.out.println(c);
	}
}

