import java.util.*;

class RentalGeneric<T> {
	private List<T> rentalPool;
	private int maxNum;
	
	public RentalGeneric(int maxNum, List<T> rentalPool) {
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	
	public T getRental() {
		return rentalPool.get(0);
	}
	
	public void returnRental(T returnedThing) {
		rentalPool.add(returnedThing);
	}
}

class Car {}
class Cat {}

public class TestRental {
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();
		carList.add(new Car());
		carList.add(new Car());
		
		RentalGeneric<Car> carRental = 
				new RentalGeneric<Car>(2, carList);
		Car carToRent = carRental.getRental();
		carRental.returnRental(carToRent);
	}
}