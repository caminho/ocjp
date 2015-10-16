import java.util.*;

public class TestSort1 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		
		lista.add("Denver");
		lista.add("Boulder");
		lista.add("Vail");
		lista.add("Aspen");
		lista.add("Telluride");
		
		System.out.println("Unsorted: " + lista);
		
		Collections.sort(lista);
		
		System.out.println("Sorted: " + lista);
	}
}
