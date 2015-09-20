import java.text.*;

public class NumberFormatMethods {
	public static void main(String[] args) {
		float f1 = 123.456789f;
		NumberFormat nf = NumberFormat.getInstance();
		System.out.print(nf.getMaximumFractionDigits() + " ");
		System.out.print(nf.format(f1) + " ");
		
		nf.setMaximumFractionDigits(5);
		System.out.println(nf.format(f1) + " ");
		
		try {
			System.out.println(nf.parse("1234,567"));
			nf.setParseIntegerOnly(true);
			System.out.println(nf.parse("1234,567"));
		} catch (ParseException e) {
			System.out.println("parse exception");
		}
	}
}
