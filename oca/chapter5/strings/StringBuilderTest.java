public class StringBuilderTest {
	public static void main(String[] args) {
	
		StringBuilder sb = new StringBuilder();
		sb.append("set ").append("point");
		System.out.println("Result: [" + sb + "], capacity: " + sb.capacity());
		
		sb = new StringBuilder("pi = ");
		sb.append(3.14159265f);

		System.out.println("Result: [" + sb + "], capacity: " + sb.capacity());
		
		sb = new StringBuilder("0123456789");
		sb.delete(4, 6);
		System.out.println("Result: [" + sb + "], capacity: " + sb.capacity());
		
		sb = new StringBuilder("01234567");
		sb.insert(4, "---");
		System.out.println("Result: [" + sb + "], capacity: " + sb.capacity());
		
		sb = new StringBuilder(0).append("ABCDEF");
		System.out.println("Result: [" + sb.reverse() + "], capacity: " + sb.capacity());
		
		sb = new StringBuilder("Test string");
		System.out.println(sb.toString());
		
		// trzy sposoby na utworzenie StringBuildera
		sb = new StringBuilder(); // capacity = 16
		System.out.println(sb.capacity());
		
		sb = new StringBuilder("abc"); // capacity = 16+3 = 19
		System.out.println(sb.capacity());
		
		sb = new StringBuilder(5); // capacity = 5
		System.out.println(sb.capacity());
		
		// trzy reguły dotyczące StringBuildera
		System.out.println("1) append - zwieksza pojemnosc");
		sb = new StringBuilder();
		System.out.println(sb.capacity()); // 16
		sb.append("0123456789");
		System.out.println(sb.capacity()); // 16
		sb.append("0123456");
		System.out.println(sb.capacity()); // 34
		System.out.println(sb);
		
		System.out.println("2) insert - zwieksza pojemnosc");
		sb = new StringBuilder();
		System.out.println(sb.capacity()); // 16
		sb.insert(0, "0123456789");
		System.out.println(sb.capacity()); // 16
		sb.insert(8, "0123456789");
		System.out.println(sb.capacity()); // 16
		System.out.println(sb);
		
		System.out.println("3) insert - wyrzuca wyjatek, gdy wstawiamy poza napis");
		sb = new StringBuilder();
		System.out.println(sb.capacity()); // 16
		sb.insert(0, "0123456789");
		System.out.println(sb.capacity()); // 16
		sb.insert(12, "01"); // StringIndexOutOfBoundsException
	}
}