public class Operators {
	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		
		System.out.println(5*2+ (y += (2 * (x += 2))));
		System.out.println(x);
		System.out.println(y);
	}
}