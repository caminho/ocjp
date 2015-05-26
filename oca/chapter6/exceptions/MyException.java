import java.util.*;

class BadFoodException extends Exception {}

public class MyException {
	private static List<String> goodFoodList = new ArrayList<String>();
	
	static {
		for (String food: new String[]{"apple", "bread", "meal", "milk"}) {
			goodFoodList.add(food);
		}
	}
	
	public static void main(String[] args) {
		for (String arg: args) {
			try {
				checkFood(arg);
			} catch (BadFoodException ex) {
				System.out.println("I really DON'T like " + arg);
			}
		}
	}
	
	static void checkFood(String food) throws BadFoodException {
		if (!goodFoodList.contains(food)) {
			throw new BadFoodException();
		}
		System.out.println("I like " + food);
	}
}

/*

$ java MyException cookies jam milk bread
I really DON'T like cookies
I really DON'T like jam
I like milk
I like bread

*/

