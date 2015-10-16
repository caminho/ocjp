public class EqualsTest {
	public static void main(String[] args) {
		Moof one = new Moof(8);
		Moof two = new Moof(8);
		if (one.equals(two)) {
			System.out.println("one and two are equal");
		}
	}
}

class Moof {
	private int value;
	
	Moof(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean equals(Object obj) {
		if ((obj instanceof Moof) && (((Moof)obj).getValue() == value)) {
			return true;
		} else {
			return false;
		}
	}
}