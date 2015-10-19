import java.util.*;

public class ListTest {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>() {{
			add("one");
			add("two");
			add("three");
		}};
		System.out.println(lista);
		
		List<List<Integer>\> listaList = new ArrayList<>();
		listaList.add(Arrays.asList(1, 2, 3));
		listaList.add(Arrays.asList(2, 3));
		listaList.add(Arrays.asList(4, 5, 6, 7));
		
		System.out.println(listaList);
	}
	
}