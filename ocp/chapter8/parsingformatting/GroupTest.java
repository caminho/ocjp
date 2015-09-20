import java.util.regex.*;

public class GroupTest {
	public static void main(String[] args) {
		String expression = args[0];
		String source = args[1];
		
		Pattern p = Pattern.compile(expression);
		Matcher m = p.matcher(source);
		
		System.out.println("\nSource: " + source);
		System.out.print(" Index: ");
		for (int i = 0; i <= source.length(); i++) {
			System.out.print((char)('0' + i % 10));
		}
		System.out.println("\nPattern: " + m.pattern());
		while (m.find()) {
			System.out.println(m.start() + " " + m.group());
		}
	}
}