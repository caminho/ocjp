import java.awt.Dimension;

public class ReferenceTest {
	public static void main(String[] args) {
		Dimension d = new Dimension(5, 10);
		ReferenceTest rt = new ReferenceTest();
		System.out.println("Before modify() d.height = "
			+ d.height);
			
		// od³o¿enie na stos metody modify() wraz
		// z kopi¹ zmiennej referencyjnej d
		rt.modify(d);
		
		System.out.println("After modify() d.height = "
			+ d.height);
	}
	
	void modify(Dimension dim) {
		dim.height = dim.height + 1;
		System.out.println("dim.height = " + dim.height);
	}
}
