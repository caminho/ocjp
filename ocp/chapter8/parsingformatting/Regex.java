import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		System.out.println("Pattern: " + m.pattern());
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " 
				+ m.group());
		}
	}
}
