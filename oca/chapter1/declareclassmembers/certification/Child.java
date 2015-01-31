package certification;

class Child extends Parent {
	public static void main(String[] args) {
		Child ch = new Child();
		ch.testIt();
	}
	
	public void testIt() {
		// moge, dostep domyslny w obrebie jednego
		// pakietu
		System.out.println("Variable x is " + x);
	}
}
