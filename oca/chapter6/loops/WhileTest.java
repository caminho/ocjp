public class WhileTest {
	public static void main(String[] args) {
		int x = 2;
		while (x == 2) {
			System.out.println(x);
			++x;
		}
		
		do {
			System.out.println("inside loop");
		} while (false);
	}
}

