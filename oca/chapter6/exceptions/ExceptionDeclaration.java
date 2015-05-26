class MyException extends Exception {}

public class ExceptionDeclaration {
	void doStuff() throws MyException {
		throw new MyException();
	}
	
	void badMethod() {
		doErrorStuff();
	}
	
	void doErrorStuff() {
		try {
			throw new Error();
		} catch (Error me) {
			throw me;
		}
	}
}

