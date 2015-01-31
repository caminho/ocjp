package somethingElse;

import certification.OtherClass;

class AccessClass {
	static public void main(String[] args) {
		OtherClass o = new OtherClass();
		
		// nie moge, testIt ma dostep domyslny i jest
		// w innym pakiecie
		//o.testIt();
	}
}
