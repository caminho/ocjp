import java.io.Console;

public class ConsoleTest {
	public static void main(String[] args) {
		Console console = System.console();
		String prompt = "Podaj liczbe: ";
		String format = "Podales: %-,20.3f\n";
		String line;
		while ((line = console.readLine(prompt)) != null) {
			console.format(format, Double.parseDouble(line));
		}
	}
}
