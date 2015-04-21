public class InstanceofComparison {
	public static void main(String[] args) {
		String s = new String("foo");
		if (s instanceof String) {
			System.out.println("s is a String");
		}
		s = null;
		if (!(s instanceof String)) {
			System.out.println("null is NOT a String");
		}
		if (!(null instanceof String)) {
			System.out.println("null is NOT a String");
		}
		if ("TOMEK" instanceof String) {
			System.out.println("\"TOMEK\" is also a String");
		}
		if (new String() instanceof String) {
			System.out.println("ho ho!");
		}
		if (doBar() instanceof String) {
			System.out.println("wolololo!");
		}
	}
	
	static String doBar() { return "trololo"; }
}