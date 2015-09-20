import java.text.*;
import java.util.*;

public class DateFormatTest {
	public static void main(String[] args) {
		Date d1 = new Date(1_000_000_000_000L);
		DateFormat[] dfa = new DateFormat[6];
		dfa[0] = DateFormat.getInstance();
		dfa[1] = DateFormat.getDateInstance();
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		for (DateFormat df : dfa) {
			System.out.println(df.format(d1));
		}
		
		System.out.println("---");
		System.out.println("d1 = " + d1.toString());
		DateFormat df = DateFormat.getDateInstance(
				DateFormat.SHORT);
		String s = df.format(d1);
		
		System.out.println(s);
		try {
			Date d2 = df.parse(s);
			System.out.println("Parsed = " + d2.toString());
		} catch (ParseException e) {
			System.out.println("Parse exception: " + e);
		}
	}
}
