import java.util.*;

public class WrapperTest {
	
	static void testIntegers(Integer i1, Integer i2) {
		System.out.println("Liczby: " + i1 + ", " + i2);
		if (i1 == i2) {
			System.out.println("obiekty te same");
		} else {
			System.out.println("obiekty sie roznia");
		}
		
		if (i1.equals(i2)) {
			System.out.println("znaczeniowo rowne");
		} else {
			System.out.println("znaczeniowo rowne");
		}
	}
	
	public static void main(String[] args) {
		Integer i1 = 1000;
		Integer i2 = 1000;
		testIntegers(i1, i2);
		
		i1 = 100;
		i2 = 100;
		testIntegers(i1, i2);
	}
}
