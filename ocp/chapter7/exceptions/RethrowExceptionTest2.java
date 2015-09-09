class A extends Exception {}

class B1 extends A {}

class B2 extends A {}

class C extends A {}

public class RethrowExceptionTest2 {
	
	void doStuff() throws B1, B2 {}
	
	public void rethrowing() throws B1, B2 {
		try {
			doStuff();
		}
		catch (A ex) {
			// ex = new B1(); // BLAD - nie mozna juz nic przypisac
			throw ex;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		new RethrowExceptionTest2().rethrowing();
	}
}
