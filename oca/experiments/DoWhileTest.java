public class DoWhileTest {
	public static void main(String[] args) {
	
		if (false) { // OK! Nie ma błędu, mimo, że kod nieosiągalny
			System.exit(0);
		}

		//final boolean condition = false;	
		//CIEKAWOSTKA: error: unreachable statement
		
		// tu ok:
		final boolean condition = new Boolean(false);
		while (condition) ;
		
		// while (false) {}	// error: unreachable statement
		// while (false) ;	// error: unreachable statement
		
		//ŹLE: error: unreachable statement
		//while (false) {
		//	System.exit(0);
		//}
		
		do {} while(false);
		do ; while(false);
		// do while (false); // ŹLE: musi być instrukcja pomiędzy "do" a "while"!
	}
}

