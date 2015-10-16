import java.util.*;

public class ListTest {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>() {{
			add("one");
			add("two");
			add("three");
		}};
		System.out.println(lista);
	}
	
}