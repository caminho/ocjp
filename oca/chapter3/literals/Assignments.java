public class Assignments {
	public static void main(String[] args) {
		int x = 7;
		int y = x + 2;
		int z = x * y;
		
		byte b = 127;
		byte c = (byte)127; //to samo
		
		char ch1 = 34; // automatycznie rzutuje na char
		short sh = 23; // automatycznie rzutuje na short
		
		byte x1 = 3;
		byte x2 = 8;
		// byte x3 = x1 + x2; ŹLE
		byte x3 = (byte)(x1 + x2);
		
		// Porządek jest ważny 
		{
			int i, j = 2, k = 4, l = k + j;
			// int m, n = m; ŹLE - n nie zainicjalizowane
			// int n = m, m = 3; ŹLE - m zadeklarowane później niż n
		}
	}
}
