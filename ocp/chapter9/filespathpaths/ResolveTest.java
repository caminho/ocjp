import java.nio.file.*;

public class ResolveTest {
	public static void main(String[] args) {
		Path dir = Paths.get("/home/dir");
		Path file1 = Paths.get("models/Model.pdf");
		Path result = dir.resolve(file1);
		System.out.println(result);
		
		Path absolute = Paths.get("C:\\Users\\Developer");
		Path abs2 = Paths.get("\\New");
		Path relative = Paths.get("dir");
		Path file = Paths.get("Model.pdf");
		System.out.println("1: " + absolute.resolve(relative));
		System.out.println("2: " + absolute.resolve(file));
		System.out.println("3: " + relative.resolve(file));
		System.out.println("4: " + relative.resolve(absolute));
		System.out.println("5: " + file.resolve(absolute));
		System.out.println("6: " + file.resolve(relative));
		System.out.println("7: " + abs2.resolve(relative));
		System.out.println("8: " + relative.resolve(abs2));
	}
}