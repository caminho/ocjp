public class EnumEqual {
	enum Color {RED, BLUE}
	public static void main(String[] args) {
		Color c1 = Color.RED;
		Color c2 = Color.RED;
		Color c = null;
		if (c1 == c2) {
			System.out.println("==");
		}
		if (c1.equals(c2)) {
			System.out.println("dot equals");
		}
		if (c.RED == Color.RED) {
			System.out.println("c.RED == Color.RED");
		}
		if (c.RED == Color.BLUE) {
			System.out.println("c.RED == Color.BLUE");
		}
		if (Color.RED == Color.RED) {
			System.out.println("Color.RED == Color.RED");
		}
	}
}