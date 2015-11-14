class A {
	static void m() {}
	void m() {}
}

public class FinalTest {
	final int i;
	//{
	//	i = 5;
	//}
	FinalTest() {
		i = 15;
	}
	FinalTest(int x) {
		// this(); // ZLE - i zostalo juz zainicjalizowane
		i = 25;
	}
	public static void main(String... args) {
		System.out.println(new FinalTest(2).i);
	}
}

