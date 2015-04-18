
public class ScopeErrors extends Foo {
	int x = 1;
	
	public static void main(String[] args) {
		// x++; èLE - b≥πd numer 1
		ScopeErrors se = new ScopeErrors();
		se.go();
		se.go3();
	}
	
	void go() {
		int y = 5;
		go2();
		y++;
	}
	
	void go2() {
		// y++; èLE - b≥πd numer 2
	}
	
	void go3() {
		for (int z = 0; z < 5; z++) {
			boolean test = false;
			if (z == 3) {
				test = true;
				break;
			}
		}
		// System.out.println(z); èLE - b≥πd numer 3
	}
}