class Frog {
	static int frogCount = 0;
	
	Frog() {
		frogCount++;
	}
}

public class TestFrog {
	static int testFrogCount = 0;
	
	public TestFrog() {
		testFrogCount++;
	}
	
	public static void main(String[] args) {
		new TestFrog();
		new TestFrog();
		new TestFrog();
		System.out.println("TestFrog counter: " + testFrogCount);
		
		TestFrog t = new TestFrog();
		System.out.println("TestFrog counter: " + t.testFrogCount);
		
		new Frog();
		new Frog();
		new Frog();
		System.out.println("Frog counter: " + Frog.frogCount);
		
		Frog f = new Frog();
		System.out.println("Frog counter: " + f.frogCount);
	}
}