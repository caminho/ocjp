
public class StringMethods {
	public static void main(String[] args) {
		String x = "airplane";
		System.out.println(x.charAt(0));
		System.out.println(x.charAt(1));
		System.out.println(x.charAt(7));
		//System.out.println(x.charAt(8)); èLE StringIdexOutOfBoundException
		
		x = "taxi";
		System.out.println(x.concat(" cab"));
		x = "library";
		System.out.println(x + " card");
		x = "Atlantic";
		x += " ocean";
		System.out.println(x);
		
		x = "Exit";
		System.out.println(x.equalsIgnoreCase("EXIt"));
		System.out.println(x.equalsIgnoreCase("tixe"));
		
		x = "01234567";
		System.out.println(x.length());
		
		x = "oxoxoxoxox";
		System.out.println(x.replace('x', 'X'));
		
		x = "0123456789";
		System.out.println(x.substring(5));   // "56789"
		System.out.println(x.substring(5, 8)); // "567"
		
		x = "A New Moon";
		System.out.println(x.toLowerCase());
		
		x = "big surprise";
		System.out.println(x.toString());	// "big surprise" :)
		
		x = "A New Moon";
		System.out.println(x.toUpperCase());
		
		x = "\b\n\t   hi\b  \n\t       ";
		System.out.println("[" + x + "]");
		System.out.println("[" + x.trim() + "]");
	}
}