class MyException extends Exception {}

class MySubException extends MyException {}

class OtherException extends Exception {}

class BadException extends Exception {}

public class RethrowExceptionTest {
	
	void test() throws MyException, 
					   OtherException,
					   BadException
	{}
	
	public void go() throws MyException, OtherException {
		try {
			test();
		} catch (BadException e) {}
		catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		new RethrowExceptionTest().go();
	}
}
