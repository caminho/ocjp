public class InnerClassNew {
	
	public void outerStuff() {
		System.out.println("OuterStuff");
	}
	
	public class Bar {
		public void doStuff() {
			outerStuff(); // OK
			InnerClassNew.this.outerStuff(); // OK
			// this.outerStuff(); // ZLE !
			System.out.println("Bar");
		}
	}
	
	public static class Fuzz {
		public void doStuff() { 
			System.out.println("Fuzz");
		}
	}
	
	public static void main(String[] args) {
		InnerClassNew outer = new InnerClassNew();
		InnerClassNew.Bar bar = outer.new Bar(); // OK
		bar.doStuff();
		Bar baz = outer.new Bar();  // OK
		baz.doStuff();
		
		InnerClassNew.Fuzz fuzz = new InnerClassNew.Fuzz();
		fuzz.doStuff();
		
		Fuzz fuzz2 = new Fuzz();
		fuzz2.doStuff();
		
		//Fuzz fuzz3 = outer.new Fuzz(); // ZLE - tak sie nie da
		//fuzz2.doStuff();
	}
}
