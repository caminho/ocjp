// enum na zewn¹trz klasy - 
// nie mo¿e byæ private ani protected!
enum CoffeeSize { 
	BIG,
	HUGE,
	OVERWHELMING
}

class Coffee {
	CoffeeSize size;
}

public class CoffeeTest1 {
	public static void main(String[] args) {
		Coffee drink = new Coffee();
		drink.size = CoffeeSize.BIG;
	}
}
