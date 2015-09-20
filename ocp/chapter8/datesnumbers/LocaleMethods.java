import java.util.*;
import java.text.*;

public class LocaleMethods {
	public static void main(String[] args) {
		Locale locBR = new Locale("pt", "BR");
		Locale locDK = new Locale("da", "DK");
		Locale locIT = new Locale("it", "IT");
		
		System.out.println("default " + locBR.getDisplayCountry());
		System.out.println("locale " + locBR.getDisplayCountry(locBR));
		
		System.out.println("default " + locDK.getDisplayLanguage());
		System.out.println("locale " + locDK.getDisplayLanguage(locDK));
		System.out.println("D>I " + locDK.getDisplayLanguage(locIT));
		
		Locale locPL = new Locale("pl", "PL");
		System.out.println("polski def. " + locPL.getDisplayLanguage());
		System.out.println("polski " + locPL.getDisplayLanguage(locPL));
		System.out.println("polski " + locPL.getDisplayLanguage(locBR));
		System.out.println("polski " + locPL.getDisplayLanguage(locIT));
	}
}