public class LiteralTest {
	public static void main(String[] args) {
		byte b = 0x7F;
		float x = 65535;
		
		// int i1 = 1; 
		// final int i1; i1 = 1; 
		// final int i1 = 1000;
		final int i1 = 1;		// niejawne zawężenie typu int->byte
		byte b1 = i1;
	}
}

