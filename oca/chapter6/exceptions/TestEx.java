public class TestEx {
	public static void main(String[] args) {
		doStuff();
	}
	
	static void doStuff() {
		doMoreStuff();
	}
	
	static void doMoreStuff() {
		int x = 5 / 0;
	}
}

/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at TestEx.doMoreStuff(TestEx.java:11)
	at TestEx.doStuff(TestEx.java:7)
	at TestEx.main(TestEx.java:3)
*/

