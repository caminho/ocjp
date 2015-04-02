enum CoffeeSize {
	BIG(8), 
	HUGE(10), 
	OVERWHELMING(16) {
		//TUTAJ CIA£O sta³ej OVERWHELMING
		
		// symbol wieczka - przes³oniêcie metody
		// z enuma CoffeeSize
		public String getLidCode() {
			return "B";
		}
	};
	
	// konstruktor
	public CoffeeSize(int ounces) {
		this.ounces = ounces;
	}
	
	// prywatna zmienna instancji
	private int ounces;
	
	// publiczna metoda - getter
	public int getOunces() {
		return ounces;
	}
	
	// symbol wieczka
	public String getLidCode() {
		return "B";
	}
}

public class Coffee {
	CoffeeSize size;
	
	public static void main(String[] args) {
		Coffee drink1 = new Coffee();
		drink1.size = CoffeeSize.BIG;
		
		Coffee drink2 = new Coffee();
		drink2.size = CoffeeSize.OVERWHELMING;
		
		System.out.println(drink1.size.getOunces());
		
		for (CoffeeSize cs: CoffeeSize.values()) {
			System.out.println(cs + " " + cs.getOunces());
		}
	}
}
