import java.io.*;

public class HandleOrDeclare {

	public void myMethod1() throws IOException { // IOException to nadklasa EOFException
		myMethod2();
		throw new IOException();
	}
	
	
	public void myMethod2() throws EOFException {
		throw new NullPointerException(); // nie trzeba deklarować - checked exception
	}
}

