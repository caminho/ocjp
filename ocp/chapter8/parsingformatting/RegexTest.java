import java.util.regex.*;

public class RegexTest {
	public static void main(String[] args) {
		String expression = args[0];
		String source = args[1];
		
		Pattern p = Pattern.compile(expression);
		Matcher m = p.matcher(source);
		
		System.out.println("\nSource: " + source);
		System.out.println(" Index: 012345678901234567890");
		System.out.println("Pattern: " + expression);
		
		System.out.print("Matches: ");
		while (m.find()) {
			System.out.print(m.start() + " ");
		}
		
	}
}
