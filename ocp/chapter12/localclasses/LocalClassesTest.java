class OuterClass {
	
	int x = 4;
	
	public void doStuff(final int x) {
		final int z = 7; 
		{
			class LocalClass {
				int x = 1;
				void seeOuter() {
					int x = 15;
					System.out.println("Local inner x = " + x);
					System.out.println("Inner instance x = " + this.x);
					System.out.println("Outer instance x = " + OuterClass.this.x);
					//System.out.println("Outer y = " + y);
					System.out.println("Local outer z = " + z);
				}
			}
			new LocalClass().seeOuter();
		}
		// new LocalClass().seeOuter(); // BLAD - tutaj klasa niewidoczna
		// nowa klasa
		class LocalClass {
			int x = 100;
			void seeOuter() {
				int x = 1500;
				System.out.println("Local inner x = " + x);
				System.out.println("Inner instance x = " + this.x);
				System.out.println("Outer instance x = " + OuterClass.this.x);
				//System.out.println("Outer y = " + y);
				System.out.println("Local outer z = " + z);
			}
		}
		new LocalClass().seeOuter();
	}
}

public class LocalClassesTest {
	public static void main(String[] args) {
		new OuterClass().doStuff(11);
		new OuterClass().doStuff(12);
		//new OuterClass().doStuff(13);
	}
}