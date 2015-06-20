public class CastingPrimitives {
	public static void main(String[] args) {		
		// Rzutowanie niejawne
		{
			int a = 100;
			long b = a;
		}
		// Rzutowanie jawne
		{
			int i1 = 2147483647;
			float f1 = i1;
			i1 = (int) f1;
			System.out.println(f1);
			System.out.println(i1);
			float f2 = 21433234823324232343647.12345456456233433322433f;
			long l1 = 123;
			float f3 = (long)221122332223212L;
			f3 = l1;
		
			float a = 100.001f;
			int b = (int)a;
			System.out.println(b);
			
			double d = 100L;
			
			//int x = 123.123; // ZLE
			int x = (int)123.123; // ucina cyfry po przecinku
			System.out.println(x);
			
			long l = 130L; // ucina bardziej znaczace liczby
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
