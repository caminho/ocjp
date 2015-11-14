class A {
	public static final int X = 15;
	
	static {
		System.out.println("loading A");
	}
}

public class LoadingClass {
	public static void main(String[] args) {
		System.out.println(A.X);
	}
}


