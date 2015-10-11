class A {
	A getCopy() { 
		System.out.println("A.getCopy()");
		return new A(); 
	}
}
class B extends A {
	@Override
	B getCopy() {
		System.out.println("B.getCopy()");
		return new B();
	}
}

interface C {
	A getA();
}

class D implements C {
	public B getA() {
		return new B();
	}
}
