public class Logical {
	public static void main(String[] args) {
		boolean b1 = false, b2 = false;
		// PO PRAWEJ PRZYPISANIE
		boolean b3 = (b1 == true) && (b2 = true); 
		System.out.println(b3 + " " + b2);
	}
}