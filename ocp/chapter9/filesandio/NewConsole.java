import java.io.Console;

public class NewConsole {
	public static void main(String[] args) {
		String name = "";
		Console console = System.console();
		char[] pw;
		pw = console.readPassword("%s", "Password: ");
		for (char ch : pw) {
			console.format("%c", ch);
		}
		console.format("\n");
		
		MyUtility mu = new MyUtility();
		while (true) {
			name = console.readLine("%s", "input?: ");
			console.format("output: %s\n", mu.doStuff(name));
		}
	}
}

class MyUtility {
	String doStuff(String arg1) {
		return "result is " + arg1;
	}
}