class OuterClass {
	
	private int x = 5;
	
	public void makeInnerObject() {
		InnerClass in = new InnerClass();
		in.seeOuter();
	}
	
	class InnerClass {
		int x = 10;
		public void seeOuter() {
			System.out.println("Outer x is: " + OuterClass.this.x);
		}
	}
}

public class InnerClassesTest {
	public static void main(String[] args) {
		new OuterClass().makeInnerObject();
		
		OuterClass.InnerClass innerObject = 
			new OuterClass().new InnerClass();
		innerObject.seeOuter();
		
		OuterClass outerObj = new OuterClass();
		OuterClass.InnerClass innerObj2 = 
			outerObj.new InnerClass();
		innerObj2.seeOuter();
	}
}