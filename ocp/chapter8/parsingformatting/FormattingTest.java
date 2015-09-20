import java.util.Locale;

public class FormattingTest {
	public static void main(String[] args) {
		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(7d<\n", i1);
		System.out.printf(new Locale("en","US"),">%0,7d<\n", i2);
		System.out.printf(">%+-7d<\n", i2);
		System.out.printf(">%2$b + %1$5d<\n", i1, false);
		double d = 12321234.3234322;
		System.out.printf(new Locale("en","US"), ">%20.10f<\n", d);
		System.out.printf(">%1$2b<\n", 333);
	}
}
