class MyException extends Exception {}

class MySubException extends MyException {}

class OtherException extends Exception {}

public class MultiCatchTest {
	
	private static void test() throws MyException, MySubException,
		OtherException {
		throw new MyException();
	}
	
	public static void main(String[] args) {
		try {
			test();
		} 
		
		// BLAD: klasy z tej samej hierarchii
		//catch (MyException | MySubException e) {
		//	System.out.println("compilation error");
		//}
		
		// BLAD: wiele nazw - jest to niedupuszczalne
		//catch (MyException e | OtherException e) {
		//	System.out.println("compilation error");
		//}
		
		catch (MySubException e) {
			System.out.println("opcjonalna obsluga MySubException");
			e = new MySubException(); // to jest ok
		}
		catch (MyException | OtherException e) {
			System.out.println("poprawne uzycie multi-catch");
			//e = new MyException(); // BLAD: nie mozna przypisac nic do 
			// parametru catch w przypadku multi-catch
			if (e instanceof MyException) {
				System.out.println("MyException");
			}
			if (e instanceof OtherException) {
				System.out.println("OtherException");
			}
		}		
	}
	
	public static void rethrow() throws MyException, OtherException {
		try {
			test();
		} catch (MyException | OtherException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
