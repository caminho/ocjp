import java.util.*;
import java.text.*;

public class LocaleTest {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 14);
		Date d = c.getTime();
		
		
		Locale locUS = new Locale("en", "US");	// j. angielski
		Locale locIT = new Locale("it", "IT");	// j. wloski
		Locale locCH = new Locale("it", "CH");	// j. wloski w Szwajcarii
		Locale locPT = new Locale("pt");		// j. port.
		Locale locBR = new Locale("pt", "BR");	// j. port. w Brazylii
		Locale locIN = new Locale("hi", "IN");	// j. hind. w Indiach
		Locale locJA = new Locale("ja");		// j. japoñski
		
		DateFormat dfPL = DateFormat.getInstance();
		System.out.println("PL\t\t" + dfPL.format(d));
		
		DateFormat dfPLFull = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("PL full\t\t" + dfPLFull.format(d));
		
		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL,
				locIT);
		System.out.println("Italy\t\t" + dfIT.format(d));
		
		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL,
				locPT);
		System.out.println("Portugal\t\t" + dfPT.format(d));
		
		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL,
				locBR);
		System.out.println("Brazil\t\t" + dfBR.format(d));
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL,
				locIN);
		System.out.println("India\t\t" + dfIN.format(d));
		
		DateFormat dfJA = DateFormat.getDateInstance(DateFormat.FULL,
				locJA);
		System.out.println("Japan\t\t" + dfJA.format(d));

		DateFormat dfUS = DateFormat.getDateInstance(DateFormat.FULL,
				locUS);
		System.out.println("US full\t\t" + dfUS.format(d));
		
	}
}
