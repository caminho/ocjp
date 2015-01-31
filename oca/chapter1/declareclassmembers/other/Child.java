package other;

import certification.Parent;

class Child extends Parent {
	public void testIt() {
		System.out.println("x is " + x);
		
		Parent p = new Parent();
		
		// nie moge, dostep chroniony nie zezwala na
		// dostep przez referencjê!
		//System.out.println("p.x is " + p.x); 
	}
}
