// import statycznej referencji obiektu out
import static java.lang.System.out;
// import wszystkich statycznych członków Integer
import static java.lang.Integer.*;

public class TestStatic {
	public static void main(String[] args) {
		out.println(MAX_VALUE);
		out.println(toHexString(42));
	}
}
