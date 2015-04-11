class Foo {
	int size;
	String name;
	Foo(String name, int size) {
		this.name = name;
		this.size = size;
	}
}

class A {
	int i;
	A() {
		this(2);
		System.out.println("A1");
	}
	
	A(int a) {
		this();
		//System.out.println("A2");
	}
}

class B extends A {
	B() {
		
		System.out.println("B1");
	}
}

public class Basics {
	public static void main(String[] args) {
		new B();
	}
}
