package certification;

class PackageChild extends Parent {
	public void testIt() {
		System.out.println("x is " + x);
		
		Parent p = new Parent();
		
		// tutaj moge, w obrebie pakietu protected
		// dziala jak dostep domyslny
		System.out.println("p.x is " + p.x); 
	}
}
