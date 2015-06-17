
public abstract class DeclarationTest {

	abstract void testMethod();
	
	//private abstract void testMethod2();
	
	//static abstract void testMethod3();
	
	//final abstract void testMethod4();
	
	private final void testMethod5() {}
	private static void testMethod6() {}
	private static final void testMethod7() {}
	
	public final synchronized strictfp static void main(String args[]) {
		System.out.println("public final synchronized strictfp " + 
			"static void main(String args[])");
		
		int [][] a = null;
		int [][] b = null, c[][] = null;
		int [][][][]d;	
				
		d = c;
	}
}

