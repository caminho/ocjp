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
	}
}