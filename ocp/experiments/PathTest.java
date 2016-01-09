import java.nio.file.*;

public class PathTest {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\..\\temp");
		System.out.println(path.normalize());
		
		System.out.println(path.resolve(Paths.get("C:\\dupa")));
	}
}