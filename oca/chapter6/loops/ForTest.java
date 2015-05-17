class Animal {}
class Dog extends Animal{}
class Cat extends Animal{}

public class ForTest {
	public static void main(String[] args) {
		for (int i = 0, j; i < 10; i++) {
			j = 16;
			System.out.println("i is " + i);
			System.out.println("j is " + j);
			//return;
		}
		// System.out.println("i is " + i); // ŹLE - zakres się skończył z końcem pętli!

		int b = 3;
		for (int a = 1; b != 1; System.out.println("iterate")) {
			b = b - a;
		}
		
		int []a = {1,2,3,4};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int n: a) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		forEachTest();
	}
	
	public static void forEachTest() {
		int x;
		long x2;
		long[] la = {7L, 8L, 9L};
		int[][] twoDee = {{1,2,3},{4,5,6},{7,8,9}};
		String[] sNums = {"one", "two", "three"};
		Animal[] animals = {new Dog(), new Cat()};
		
		// prawidlowe uzycie
		for (long y : la);
		for (int[] n: twoDee);
		for (int n2: twoDee[2]);
		for (String s: sNums);
		for (Object o: sNums);
		for (Animal a: animals);
		
		// nieprawidlowe
		// for (x2 : la); // x2 jest juz zdefiniowane wczesniej
		// for (int i2: twoDee); // niekompatybilnosc typow
		// for (int x3: la); // nie mozna iterować intem po tablicy longów
		// for (Dog d: animals); // niekompatybilnosc typow - Dog nie jest podklasą Animal!
	}
}

