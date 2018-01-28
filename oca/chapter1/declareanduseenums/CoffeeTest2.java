// definicja enuma w klasie
class Coffee2 {
	enum CoffeeSize { BIG, HUGE, OVERWHELMING }
	CoffeeSize size;
}

public class CoffeeTest2 {
	public static void main(String[] args) {
		Coffee2 drink = new Coffee2();
		// należy odwołać się do stałem enum przez nazwę
		// klasy i enuma
		drink.size = Coffee2.CoffeeSize.BIG;
	}
}
