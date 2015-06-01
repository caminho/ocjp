public class ScopeTest {

	int a = 5;
	int b = a;
	

	static int x = 5;

	public final static void main(String[] args) {
		
		System.out.println(x);
		
		int x = 10;	// shadowing - od miejsca definicji do końca bloku
		
		System.out.println(ScopeTest.x);
		System.out.println(x);
		
		for (String s: args) {
			System.out.println(s);
			
			//for (String s: new String[]{"123"}) {   <--- "s" jest już zdefiniowane - błąd
			//	System.out.println(s);
			//}
			
		}
	}
}

