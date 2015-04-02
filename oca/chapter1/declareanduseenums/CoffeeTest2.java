// definicja enuma w klasie
class Coffee2 {
	enum CoffeeSize { BIG, HUGE, OVERWHELMING }
	CoffeeSize size;
}

public class CoffeeTest2 {
	public static void main(String[] args) {
		Coffee2 drink = new Coffee2();
		// nale¿y odwo³aæ siê do sta³ej enum przez nazwê 
		// klasy i enuma
		drink.size = Coffee2.CoffeeSize.BIG;
	}
}
