class Animal {}
class Dog {}

class Car {} 
class Subaru extends Car {} 
class Ferrari extends Car {}
	
public class ArrayTest {
	public static void main(String[] args) {
		int[] key;
		int[] tab1[], zmienna, tab3[][];
		tab1 = new int[1][];
		zmienna = new int[5];
		tab3 = new int[2][][];
		
		float[][] f1, f2[], f3[][];
		f1 = new float[1][];
		f2 = new float[1][][];
		f3 = new float[1][][][];
		
		double[][][] d1[][] = new double[5][][][][];
		
		Thread[] threads;
		threads = new Thread[15];
		Thread manyThreads[] = new Thread[16];
		
		// Konstrukcja tablicy
		int[][] myArray = new int[3][];
		myArray[0] = new int[2];
		myArray[0][0] = 6;
		myArray[0][1] = 7;
		myArray[1] = new int[3];
		myArray[1][0] = 9;
		myArray[1][1] = 8;
		myArray[1][2] = 5;

		// Inicjalizacja tablicy
		Animal[] pets = new Animal[3];
		pets[0] = new Animal();
		pets[1] = new Animal();
		pets[2] = new Animal();
		// pets[-1] = new Animal(); // ŹLE - skompiluje sie, ale wyjatek w czasiw wykonania
		
		int[][] scores = new int[3][];
		scores[0] = new int[4];
		scores[1] = new int[6];
		scores[2] = new int[1];
		
		// Inicjalizowanie w pętli
		Dog[] dogs = new Dog[5];
		for (int i = 0; i < dogs.length; i++) {
			dogs[i] = new Dog();
		}
		
		// Inicjalizacja w jednej linii
		int x = 12;
		int[] dots = {6, x, 7};
		
		int[] dots2;
		// dots2 = {1,2,3}; ŹLE
		
		// dots = {6, x, 7}; // ŹLE - wersja skrócona tylko przy deklaracji
		
		Dog puppy = new Dog();
		Dog[] myDogs = {puppy, new Dog(), new Dog(), new Dog()};
		int[][] scores2d = {{1,2,3}, null, {}};
		int[] emptyTab = {};
		System.out.println("emptyTab.length = " + emptyTab.length);
		
		// Anonimowe tablice
		dots = new int[]{12, 23, 34};
		takeAnArray(new int[2]);
		takeAnArray(new int[]{1,2});
		// takeAnArray({1,2}); // źle!
		takeAn2DArray(new int[2][]);
		takeAn2DArray(new int[][]{  new int[]{2,3}  }); // jeden element - tablica o 2 elementach
		takeAn2DArray(new int[][]{  {}  }); // jeden element - pusta tablica w wersji skróconej
		
		// dots = {}; ŹLE - wersja skrócona nie działa przy samej inicjalizacji/przypisaniu

		int[][] cats = new int[][] { {} };
		cats = new int[][] { {} };
		int[][] cats2 = new int[][] { new int[]{} };
		
		Dog myDogs2[] = new Dog[]{puppy, new Dog(), new Dog(), new Dog()};
		
		// jeszcze mała zagadka:
		{
			int[][] a, b[] = new int[][][]{{{}}, null, {}, new int[2][], new int[][]{{},{}}};
		}
		
		// Przypisania elementom tablic
		
		// 	1) tablice prymitywów
		int[] weightList = new int[5];
		byte b = 4;
		char c = 'c';
		short s = 7;
		weightList[0] = b;
		weightList[1] = c;
		weightList[2] = s;
		
		// 	2) tablice referencji
		Car[] cars = {new Car(), new Subaru(), new Ferrari()};
	}
	
	public static void takeAn2DArray(int[][] someArray) {
	}
	
	public static void takeAnArray(int[] someArray) {
	}
}
