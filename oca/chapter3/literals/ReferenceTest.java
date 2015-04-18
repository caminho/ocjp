class Foo{
	void doFooStuff(){};
}
class Bar extends Foo {
	void doBarStuff(){};
}

public class ReferenceTest {
	public static void main(String[] args) {
		Foo reallyABar = new Bar();
		reallyABar.doFooStuff();
		((Bar)reallyABar).doFooStuff();
		// Bar reallyAFoo = new Foo(); ŹLE
		// Bar reallyAFoo = (Bar)new Foo(); // RUNTIME!
		// reallyAFoo.doBarStuff(); // ŹLE
	}
}
