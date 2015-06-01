class Car {}
class Honda extends Car {}
class Beer {}

interface Foldable{}
class Box implements Foldable {}

class A{}
class B extends A{}

public class ArrayAssignments {
	public static void main(String[] args) {
	
		int[] splats;
		int[] dats = new int[4];
		char[] letters= new char[5];
		splats = dats; // OK
		// splats = letters; // ŹLE - inny typ obiektu! tablica jest obiektem
	
		Car[] cars;
		Honda[] cuteCars = new Honda[5];
		cars = cuteCars; // OK - Honda rozszerza Car: Honda IS-A Car
		Beer[] beers = new Beer[5];
		// cars = beers;	// ŹLE - Beer nie rozszerza Car
		
		Foldable[] foldingThings;
		Box[] boxThings = new Box[5];
		foldingThings = boxThings; // OK, Box IS-A Foldable
		
		int[] blots;
		int[][] squeegees = new int[3][];
		//blots = squeegees; // ŹLE - inna liczba wymiarów
		int[] blocks = new int[6];
		blots = blocks; // OK - ta sama liczba wymiarów
		
		int[][] books = new int[3][];
		int[] numbers = new int[6];
		int aNumber = 7;
		// books[0] = aNumber; // źle - zła liczba wymiarów
		books[0] = numbers; // ok - numbers to tablica
		
		A[] a;
		B[] b;
		a = new A[5]; // OK
		a = new B[5]; // OK
		b = new B[5]; // OK
		a = b;
		// b = a; // ŹLE: error: incompatible types
		b = (B[])a;
		a = new A[5];
		// b = (B[])a; // ŹLE: ClassCastException
		// b = new A[5]; // ŹLE: error: incompatible types
	}
}

