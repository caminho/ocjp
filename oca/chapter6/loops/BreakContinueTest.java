public class BreakContinueTest {
	public static void main(String[] args) {
	
		// continue nieetykietowane
		for (int i = 0; i < 10; i++) {
			System.out.println("inside loop");
			continue;
		}
		for (int i = 0, j; i < 10; i++) {
			System.out.println("i is " + i);
			if (i < 6) {
				continue;
			}
			System.out.println("i >= 6!");
		}
		
		// break nieetykietowane
		boolean problem = true;
		while (true) {
			if (problem) {			
				System.out.println("Wystapil blad");
				break;
			}
		}
		// następna linia
		
		// petla do i continue
		int i = 0;
		do {
			System.out.println("i = " + i);
			if (i < 6) {	  // krok iteracyjny jest w klauzuli while
				continue; // ponieważ sprawdzenie warunku pętli wykona się
					  // nie jest to pętla nieskończona 
			}
			System.out.println("i >= 6!");
		} while (i++ < 10);
		
		// break z etykietą
		boolean isTrue = true;
		outer: for (int z = 0; z < 5; z++) {
			inner: while (isTrue) {
				System.out.println("hello");
				break outer;
			} // koniec pętli wewnętrznej
			System.out.println("outer loop"); // nigdy sie nie wyswietli
		} // koniec pętli zewnętrznej
		System.out.println("good bye");
		
		// continue z etykietą
		outer: for (int z = 0; z < 5; z++) {
			for (int k = 0; k < 5; k++) {
				System.out.println("hello");
				continue outer;
			} // koniec pętli wewnętrznej
			System.out.println("outer loop"); // nigdy sie nie wyswietli
		} // koniec pętli zewnętrznej
		System.out.println("good bye");
		
		// cwiczenie 6-2
		int age = 0;
		outer: while (age <= 21) {
			age++;
			if (age == 16) {
				System.out.println("get your driving license");
			} else {
				System.out.println("another year");
				continue outer;
			}
		}
	}
}

