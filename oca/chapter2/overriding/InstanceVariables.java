class Foo {
	int x = 1;
	
	int getX() {return x;};
}

class Bar extends Foo {
	// Redefinicja zmiennej! NIE MA B£ÊDU
	int x = 1000;
	
	@Override
	int getX() {return x;}
	
	int getSuperX() {return super.getX();}
}

public class InstanceVariables {
	
	public static void main(String[] args) {
		
		Foo f = new Foo();
		System.out.println("f.getX() = " + f.getX());
		System.out.println("f.x = " + f.x);
		
		Bar b = new Bar();
		System.out.println("b.getX() = " + b.getX());
		System.out.println("b.x = " + b.x);
		System.out.println("b.getSuperX() = " + b.getSuperX());
		
		f = b;
		System.out.println("f.getX() = " + f.getX());
		System.out.println("f.x = " + f.x);
	}
}
