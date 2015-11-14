public class ArrayTest {


	static int[] getArray(int[] a) {
		System.out.println("najpierw okreslam referencje");
		//throw new RuntimeException("okreslanie referencji");
		return null;
	}
	
	static int getIndex() {
		System.out.println("teraz obliczany jest indeks");
		//throw new RuntimeException("obliczanie indeksu");
		 return 16; //(a = b)[3];
	}

	static int computeValue() {
		System.out.println("teraz obliczana jest wartosc");
		throw new RuntimeException("obliczanie wartosci");
		//return 15;
	}
	
	static int[] a = { 1, 2, 3, 4 };
	static int[] b = { 2, 3, 1, 0 };

	static Integer getI1(){
		System.out.println("a2d indeks1");
		//throw new RuntimeException("obliczanie indeksu 1");
		return null;
	}
	static int getI2(){
		System.out.println("a2d indeks2");
		throw new RuntimeException("obliczanie indeksu 2");
		//return 0;
	}

	public static void main(String[ ] args){

		int[][] a2d = {{1, 2}, {3}};

		a2d[getI1()][getI2()] = computeValue();
		//System.out.println(a2d[getI1()][getI2()]);

		try {	
		
			// System.out.println( getArray(a) [ getIndex() ] );
			
			//int x = getArray(a) [ getIndex() ] = computeValue();
			
			//System.out.println( "Pobrana wartosc po przypisaniu: " + x);
			
		} catch (Exception e) {
			System.out.println("Zlapalem: " + e);
		}

	}
}

