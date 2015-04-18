public class Assignments {
	public static void main(String[] args) {
		// Przypisanie
		{
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
		}
		// Porządek jest ważny 
		{
			int i, j = 2, k = 4, l = k + j;
			// int m, n = m; ŹLE - n nie zainicjalizowane
			// int n = m, m = 3; ŹLE - m zadeklarowane później niż n
		}
		// Przypisanie liczby zmiennoprzecinkowej
		{
			// float f = 12.3;  ŹLE
			// Poprawnie
			float f1 = (float) 12.3;
			float f2 = 12.3f;
			float f3 = 12.3F;
		}
		// Przypisanie zbyt dużego literału
		{
			// byte a = 128; ŹLE
			byte a = (byte) 128;
			System.out.println(a);  // -128
			
			byte b = 127;
			b += 7534534L;
			
			// Równoważne temu:
			int c  = (int)(b + 7534534L);
			// bez rzutowanie nie przejdzie:
			// b  = b+7; ŹLE			
		}
		// Przypisanie jednej zmiennej do drugiej
		{
			int a = 10;
			System.out.println(a);
			int b = a;
			b = 30;
			System.out.println(a);
		}
		// Wrapper objects
		Long x = new Long(12);
		Short y = new Short("23");
	}
}
