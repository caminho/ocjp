import java.io.*;


class A {
	//A() throws IOException  {}
}

class B extends A {

/*
error: unreported exception IOException; must be caught or declared to be thrown
	B() throws FileNotFoundException, IllegalArgumentException {
*/
	//B() throws FileNotFoundException, IllegalArgumentException {
	//}
}

class MyException extends Exception {}
class MyException2 extends Exception {}
public class ExceptionTest {

	static {
		//int i = 1/0;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		ExceptionTest tc = new ExceptionTest();
		try{
			tc.m1();
		}
		catch (MyException e){
			//tc.m1();
		}
		finally{
			//tc.m3();
			//throw new NullPointerException();
		}
		
		new CloneMe().clone();
		
	}
	
	public void m1() throws MyException{
		throw new MyException();
	}
	
	public void m2() throws MyException2{
		throw new MyException2();
	}
	
	public void m3() throws RuntimeException{
		throw new NullPointerException();
	}
}


class CloneMe implements Cloneable {

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

