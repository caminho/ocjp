public class StringTest {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = new String(s1);
		String s3 = new String(s1);
		String replaced1 = s1.replace('V','Z');		// nie tworzy nowego obiektu
		String replaced2 = s1.replace('a','Z');		// tworzy nowy obiekt
		String replaced3 = s1.replace('b','b');		// nie tworzy nowego obiektu
		
		printHashCode("\"abcd\"", "abcd");
		printHashCode("s1", s1);
		printHashCode("s2", s2);
		printHashCode("s3", s3);
		printHashCode("replaced1", replaced1);
		printHashCode("replaced2", replaced2);
		printHashCode("replaced3", replaced3);
		
		StringBuilder sb = new StringBuilder("abc");
		try {
			sb.insert(10, "def");
		} catch (StringIndexOutOfBoundsException ex) {
			System.out.println("Hola hola!");	
		}
		
		Object o1 = new String("abcd");
		System.out.println(o1.equals("abcd"));
		
	}
	
	public static void printHashCode(String var, Object obj) {
		int hashCode = System.identityHashCode(obj);
		System.out.println(var + ".#" + Integer.toHexString(hashCode) + " = " + obj.toString());
	}
	
	public static void printHashCode(Object obj) {
		int hashCode = System.identityHashCode(obj);
		System.out.println(obj.toString() + ": " + Integer.toHexString(hashCode));
	}
}

