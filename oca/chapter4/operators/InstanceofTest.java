class Cat {}
class Dog {
	public static void itsGoingToFail() {
		Dog d = new Dog();
		// System.out.println(d instanceof Cat); èLE
	}
}

class A {}

class B extends A {
	public static void main(String[] args) {
		A myA = new B();
		m2(myA);
	}
	
	public static void m2(A a) {
		// zaliczenie testu daje zielone úwiat≥o do rzutowania w dÛ≥
		if (a instanceof B) {
			((B)a).doBstuff();
		}
		if (a instanceof Object) {
			System.out.println("a jest obiektem");
		}
		if (! (null instanceof Object)) {
			System.out.println("null nie jest obiektem");
		}
	}
	
	public static void doBstuff() {
		System.out.println("'a' refers to a B");
	}
}