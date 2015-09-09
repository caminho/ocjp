public class AssertionTest {

	private void methodA(int num) {
		//assert (num >= 0);
		assert num >= 0;
		System.out.println(num);
	}

	private void doStuff1(int x, int y) {
		assert (y > x);
		System.out.println("y = " + y + ", x = " + x);
	}
	
	private void doStuff2(int x, int y) {
		//assert (y > x): "y = " + y + ", x = " + x;
		assert computeResult(y > x): "y = " + y + ", x = " + x;
		
		System.out.println("y = " + y + ", x = " + x);
	}
	
	private boolean computeResult(boolean input) {
		System.out.println("Result is: " + input);
		return input;
	}
	
	public static void main(String... args) {
		AssertionTest at = new AssertionTest();
		try {
			at.methodA(5);
			at.methodA(10);
			at.methodA(-15);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		try {
			at.doStuff1(1, 2);
			at.doStuff1(2, 1);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		try {
			at.doStuff2(1, 2);
			at.doStuff2(2, 1);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
