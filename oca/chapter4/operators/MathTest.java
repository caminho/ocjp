public class MathTest {
	static int players = 0;
	
	public static void main(String[] args) {
		int x = 5 * 3;
		int y = x - 4;
		System.out.println("x - 4 is " + y);
		
		x = 15;
		y = x % 4;
		System.out.println("x % 4 is " + y);
		
		System.out.println("players online: " + players++);
		System.out.println("the value of players is: " + players);
		System.out.println("the value of players is: " + ++players);
		
		final int z;
		z = 7;
		// z++; ZLE
		
		System.out.println(.02);
		System.out.println(2.);
	}
}
