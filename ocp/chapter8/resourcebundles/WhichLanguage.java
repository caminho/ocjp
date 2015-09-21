import java.util.Locale;
import java.util.ResourceBundle;

public class WhichLanguage {
	public static void main(String[] args) {
		if (args.length == 1) {
			Locale loc = new Locale(args[0]);
			ResourceBundle rb = ResourceBundle.getBundle("Labels", loc);
			System.out.println(rb.getString("hello"));
		} else if (args.length == 2) {
			Locale loc = new Locale(args[0], args[1]);
			ResourceBundle rb = ResourceBundle.getBundle("Labels", loc);
			System.out.println(rb.getObject("hello"));
		}
	}
}
