class Foo {}

public class SynchronizationTest {
	public static void main(String[] args) {
		Foo foo = new Foo();
		synchronized (foo) {
			System.out.println("synchronized context");
		}
	}
}