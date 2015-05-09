interface Sporty {
	void beSporty();
}

class Car {}

class Ferrari extends Car implements Sporty {
	public void beSporty() {
		System.out.println("Ferrari is sporty!");
	}
}

class AthleticShoe {}

class RacingFlats extends AthleticShoe implements Sporty {
	public void beSporty() {
		System.out.println("RacingFlats is sporty!");
	}
}

class GolfClub {}

public class TestSportyThings {
	public static void main(String[] args) {
		Sporty[] sportyThings = new Sporty[3];
		sportyThings[0] = new Ferrari();
		sportyThings[1] = new RacingFlats();
//		sportyThings[2] = new GolfClub(); ŹLE - nie implementuje interfejsu
	}
}

