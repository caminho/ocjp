public class CaseTest {
	public static void main(String[] args) {
		int i = 0;
		final int C = 2;
		outer_switch: 
		switch(C) {
		// switch(2) { // alternatywnie
			case C: 
				System.out.println("2!");
				while (i++ < 1) {
					// int i = 3; // ŹLE: already defined
					if (C == 2) {
						// break outer_switch; // TEŻ DZIAŁA!
						break; // break w if opuszcza pętlę while
						       // z etykietą opuści cały switch
					}
				}
				// break; // ŹLE: unreachable statement dla kolejnej instrukcji
				
				System.out.println("kontynuujmy...");
			// case 2: {} // error: duplicate case label
			
			default: // tu nie ma błędu "unreachable code"!
				 // chociaż poniższa instrukcja nigdy się nie wykona
				System.out.println("default");
		}
	}
}

