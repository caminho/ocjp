import java.util.*;

interface Interface1 {}
interface Interface2 {}
class Class1{}

class Class2 extends Class1  implements Interface1 {}

class Generic<T extends Class1 & Interface1, U> {
	
}

public class MultipleBounds {
	public static void main(String[] args) {
		Generic<Class2, Interface2> generic = new Generic<>();
	}
}