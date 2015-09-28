import java.nio.file.Path;
import java.nio.file.Paths;

public class IterablePathTest {
	public static void main(String[] args) {
		
		Path path = Paths.get("C:\\Users\\Developer\\git\\ocjp\\ocp\\"
			+ "chapter9\\filespathpaths");
		int spaces = 1;
		for (Path element: path) {
			System.out.format("%" + spaces + "s%s%n", "", element);
			spaces += 2;
		}
	}
}