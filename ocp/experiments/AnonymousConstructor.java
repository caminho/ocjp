public class AnonymousConstructor {
	
	class Bar {
		Bar(String s) {
			System.out.println(s);
		}
	}
	
	void go() {
		// Bar bar = new Bar(String s) {}; // ZLE - niepoprawna skladnia
		Bar bar = new Bar("halo");
	}
	
	public static void main(String[] args) {
		new AnonymousConstructor().go();
	}
}
