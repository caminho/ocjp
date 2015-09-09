public class ValidAssert {
	
	void noReturn() {}
	
	int aReturn() { return 1; }
	
	void go() {
		int x = 1;
		boolean b = true;
		
		// poprawne uzycie asercji
		assert (x == 1);
		assert (b);
		assert true;
		assert (x == 1): x;
		assert (x == 1): aReturn();
		assert (x == 1): new ValidAssert();
		
		// niepoprawne uzycie asercji
		//assert (x = 1);
		//assert (x);
		//assert 0;
		//assert (x == 1): ;
		//assert (x == 1): noReturn();
		//assert (x == 1): ValidAssert va;
	}
	
	public static void main(String args[]) {
		new ValidAssert().go();
	}
}
