public class CastingPrimitives {
	public static void main(String[] args) {		
		// Rzutowanie jawne
		{
			int a = 100;
			long b = a;
		}
		// Rzutowanie niejawne
		{
			float a = 100.001f;
			int b = (int)a;
			System.out.println(b);
			
			double d = 100L;
			
			//int x = 123.123; // èLE
			int x = (int)123.123; // ucina cyfry po przecinku
			System.out.println(x);
			
			long l = 130L; // ucina bardziej znaczπce liczby
			byte b2 = (byte)l;
			System.out.println(b2);
			
			// cw. 3-1
			float f = 234.56f;
			short s = (short)f;
			System.out.println(s);
			
			byte b3 = (byte)f;
			System.out.println(b3);
			byte b4 = (byte)234;
			System.out.println(b4);
		}
	}
}