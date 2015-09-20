import java.util.*;
import java.text.*;

public class NumberFormatTest {
	public static void main(String[] args) {
		float f1 = 123.456f;
		Locale locFR = new Locale("fr");
		NumberFormat[] nfa = {
			NumberFormat.getInstance(),
			NumberFormat.getInstance(locFR),
			NumberFormat.getCurrencyInstance(),
			NumberFormat.getCurrencyInstance(locFR),
		};
		
		for (NumberFormat nf : nfa) {
			System.out.println(nf.format(f1));
		}
	}
}
