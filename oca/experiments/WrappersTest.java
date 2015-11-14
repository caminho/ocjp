public class WrappersTest {


	static Byte b;

	public static void main(String... args) {
		Short s = 9;
		// Short s2 = new Short(9); // ZLE
		
		Integer i = new Integer(42);
		Long ln = new Long(42);
		Double d = new Double(42.0);
		
		Float f = new Float(42);
		
		// Byte b = new Byte(42); // ZLE
		
		
		System.out.println(b);
		
		int malyInt = 42;
		
		System.out.println(i == malyInt);
		System.out.println(ln == malyInt);
		System.out.println(d == malyInt);
		System.out.println(f == malyInt);
		
		System.out.println(ln.equals((long)42));
		
		short s2 = 9;
		System.out.println(new Integer(9) == s2);
	}
}

