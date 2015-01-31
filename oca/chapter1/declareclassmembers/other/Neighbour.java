package other;

class Neighbour {
	public void testIt() {
		Child c = new Child(); // mogê, bo default access
		
		// nie moge, dostep do metody chroniony
		// System.out.println("c.x is " + c.x); 
	}
}
