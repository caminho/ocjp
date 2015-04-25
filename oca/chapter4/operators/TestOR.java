public class TestOR {
	public static void main(String[] args) {
		if (isSmall(3) || isSmall(7)) {
			System.out.println("Result is TRUE");
		}
		
		if (isSmall(6) || isSmall(9)) {
			System.out.println("Result is TRUE");
		}
		
		int z = 5;
		if (++z > 5 || ++z > 6) {
			++z;
		}
		System.out.println(z);
		
		z = 5;
		if (++z > 5 | ++z > 6) {
			++z;
		}
		System.out.println(z);
		
		System.out.println("xor " + (2 < 3 && 4 > 3));
		
		if (!(7 == 5)) {
			System.out.println("not equal");
		}
		
		boolean t = true;
		boolean f = false;
		System.out.println("! " + (t & !f) + " " + f);
	}
	
	public static boolean isSmall(int i) {
		if (i < 5) {
			System.out.println("i < 5");
			return true;
		} else {
			System.out.println("i >= 5");
			return false;
		}
	}
}
/*
	i < 5
	Result is TRUE
	i >= 5
	i >= 5
*/