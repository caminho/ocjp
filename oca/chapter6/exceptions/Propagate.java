// cwiczenie 6-3

public class Propagate {
	public static void main(String[] args) {
		try {
			System.out.println("reverse(\"ABC\") = " + reverse("ABC"));
			System.out.println("reverse(\"\") = " + reverse(""));  //EXCEPTION
			System.out.println("reverse(\"JAVA\") = " + reverse("JAVA"));
		} catch (Exception ex) {
			System.out.println("wyjątek!");
		} finally {
			System.out.println("koniec");
		}
	}
	
	static String reverse(String s) throws Exception {
		if (s.length() == 0) {
			throw new Exception();
		}
		return new StringBuffer(s).reverse().toString();
	}
}

