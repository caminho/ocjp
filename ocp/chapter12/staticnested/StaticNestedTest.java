class BigOuter {
	private static final int X = 12;
	
	static class Nest {
		void go() {
			System.out.println("hi");
			System.out.println("Private X: " + X);
		}
	}
}

class Broom {	
	static class B2 {
		void go2() {
			System.out.println("hi 2");
		}
	}
	
	static void goBroom() {
		BigOuter.Nest n = new BigOuter.Nest();	
		n.go();
		B2 b2 = new B2();
		b2.go2();
	}
}

public class StaticNestedTest {
	public static void main(String[] args) {
		Broom.goBroom();
	}
}