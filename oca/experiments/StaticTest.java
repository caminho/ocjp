class A {
	static void doStuffA() {}
	
	void test() {
		System.out.println("A.test()");
	}
}

class B extends A {
	
	static int test = 3;
	

	// void doStuffA() {} // ZLE - metoda o takiej samej nazwie jest 
	// statyczna w nadklasie

	synchronized strictfp void test() {
		System.out.println("B.test()");
	}
	
	 strictfp native void dupa();
}

public class StaticTest {
	public static void main(String[] args) {
		A a = new B();
		a.test();
	}
}

