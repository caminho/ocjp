class MyResource implements AutoCloseable{
	String name;
	
	public MyResource(String name) {
		this.name = name;
	}
	
	public void doStuff() {
		System.out.println("doStuff with " + name);
	}
	
	public void close()  {
		System.out.println("Closing " + name);
	}
}

public class AutoCloseableTest {
	public static void main(String[] args) {
		try (MyResource mr = new MyResource("Plik1")) {
			mr.doStuff();
		}
	}
}
