class Animal {}
class Horse extends Animal {}

interface Chewable {}
class Gum implements Chewable {}

class ReturningValue {
	public Object doStuff() {
		return null;
	}
	
	public String[] go() {
		return new String[] {
			"Fred", "Barney", "Wilma"
		};
	}
	
	public int foo() {
		char c = 'c';
		return c; // char jest kompatybilny z int
	}
	
	public int bar() {
		float f = 32.5f;
		return (int) f;
	}
	
	public void baz() {
		return /* null */;
	}
	
	public Animal getAnimal() {
		return new Horse();
	}
	
	public Object getObject() {
		int[] nums = {1,2,3};
		return nums;
	}
	
	public Chewable getChewable() {
		return new Gum();
	}
}
