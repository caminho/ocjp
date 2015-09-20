import java.util.*;

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("a bc d e");
		System.out.println("\n " + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.print(">" + st.nextToken() + "<  ");
		}
		StringTokenizer st2 = new StringTokenizer("a b c,ab a ba d", "a,b");
		System.out.println("\n " + st2.countTokens());
		while (st2.hasMoreTokens()) {
			System.out.print(">" + st2.nextToken() + "<  ");
		}
		System.out.println("\n " + st2.countTokens());
	}
}
