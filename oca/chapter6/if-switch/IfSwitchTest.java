public class IfSwitchTest {
	public static void main(String[] args) {
	
		// Instrukcja If-else
		int x = 6;
		if (x > 3) {
			System.out.println("x is greater than 3");
		} else {
			System.out.println("x is lower than 3");
		}
		
		int price = 900;
		if (price < 300) {			
			System.out.println("kupujemy!");
		
		} else {
			if (price < 400) {			
				System.out.println("potrzebne pozwolenie");
			} else {
				System.out.println("za drogie!");
			}
		}
		
		// if-else-if
		if (price < 300) {			
			System.out.println("kupujemy!");
		} else if (price < 400) {			
			System.out.println("potrzebne pozwolenie");
		} else {
			System.out.println("za drogie!");
		}
		
		int y = 5;
		x = 2;
		if (((x > 3) && (y < 2)) | doStuff()) {
			System.out.println("true");
		}
		if ((x > 3) && (y < 2) | doStuff()) {
			System.out.println("true");
		}
		// to samo co powyżej - | ma wyższy priorytet niż &&
		if ((x > 3) && ((y < 2) | doStuff())) {
			System.out.println("true");
		}
		
		// switch
		byte switchExpression = 3;
		final int one = 1;  // stala
		// final int one; one = 1;  ŹLE - inicjalizacja musi być przy deklaracji
		// int one = 1; ŹLE - to nie stała
		switch (switchExpression) {
			case one: 
				System.out.println("switchExpression = 1");
				break;
			case 2: 
				System.out.println("switchExpression = 2");
				break;
			case 3:
			case 4:
			// case 4: ŹLE - duplicate case label
			case 5: 
				System.out.println("switchExpression = 3, 4 lub 5");
				break;
			// case 128: ŹLE - possible loss of precision
			default:
				System.out.println("switchExpression jest spoza zbioru {1,2,3,4,5}!");
		}
		
		switch (new Integer(5)) {
			case 5: System.out.println("autoboxing działa w switchu");
		}
		
		switch ("string") {
			case "String": System.out.println("String"); break;
			case "string": {
				System.out.println("string"); 
			} 
			break;
			case "STRING": System.out.println("STRING"); break;
		}
		
		// default
		String s = "green";
		switch (s) {
			case "red": System.out.print("red "); 
			case "green": System.out.print("green "); 
			case "blue": System.out.print("blue "); 
			default: System.out.println("done"); 
		}
		
		x = 4;
		switch (x) {
			// fall-through
			case 2: case 4: case 6: case 8: case 10:
				System.out.println("x jest parzyste"); 
				break;
			default:
				System.out.println("x jest nieparzyste"); 
		}
		
		// default może być w dowolnej pozycji między case'ami
		// x = 2;
		x = 7;
		switch (x) {
			case 2: System.out.print("2 "); 
			default: System.out.print("default "); 
			case 3: System.out.print("3 "); 
			case 4: System.out.println("4"); 
		}
		
		// cwiczenie 6-1
		char znak = 'a';
		switch (znak) {
			default:
				System.out.println("nieznany znak!");
				break;
			case 'a': 
				System.out.println("a"); 
				break;
			case 'b': 
				System.out.println("b"); 
				break;
			case 'c': 
				System.out.println("c"); 
				break;
				// System.out.println("d"); ŹLE - błąd kompilacji, wyrażenie nieosiągalny
		}
	}
	
	public static int oneFunc() {
		return 1;
	}
	
	public static boolean doStuff() {
		System.out.println("doStuff(): true!");
		return true;
	}
}

