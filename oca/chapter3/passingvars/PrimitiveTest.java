import java.awt.Dimension;

public class PrimitiveTest {
	public static void main(String[] args) {
		int a = 1;
		PrimitiveTest rt = new PrimitiveTest();
		
		System.out.println("Before modify() a = "
			+ a);
		rt.modify(a);
		System.out.println("After modify() a = "
			+ a);
	}
	
	void modify(int num) {
		num = num + 1;
		System.out.println("num = " + num);
	}
}
