public class StringTest {
	public static void main(String[] args) {
		String x = "Java";
		String y = x;
		System.out.println("y string = " + y);
		
		x = x + "Bean";
		System.out.println("y string = " + y);
		
		String s = "asd";
		s.toUpperCase();
		System.out.println(s);
	}
}
