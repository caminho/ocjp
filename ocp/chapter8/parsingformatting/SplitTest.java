public class SplitTest {
	public static void main(String[] args) {
		String[] tokens = args[0].split(args[1]);
		System.out.println("Count: " + tokens.length);
		for (String token: tokens) {
			System.out.println(">" + token + "<");	
		}
	}
}
