class A {
	void doStuff() {
		System.out.println("Outer A");
	}
}

public class AmbiguousClasses {

	class A {
		void doStuff() {
			System.out.println("Regular inner A");
		}
	}
	
	void go() {
		new A().doStuff();
		class A {
			void doStuff() {
				System.out.println("Local inner A");
			}
		}
		new A().doStuff();
	}
	
	public static void main(String[] args) {
		new AmbiguousClasses().go();
	}
}
