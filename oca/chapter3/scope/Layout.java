public class Layout {
	static int s = 343; // zmienna statyczna
	int x; // zmienna instancji
	
	{
		x = 7; int x2 = 5; // x2 - zmienna bloku init (lokalna)
	}
	
	Layout() {
		x += 8;
		int x3 = 6; // zmienna konsktruktora (lokalna)
	}
	
	void doStuff() {
		int y = 0;	// zmienna lokalna (metody)
		for (int z = 0; z < 4; z++) { // z - zmienna bloku for
			y += z + x;
		}
	}
}