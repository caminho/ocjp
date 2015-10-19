import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class DirectoryStreamTest {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get(".");
		try (
			DirectoryStream<Path> dirStream = Files
				//.newDirectoryStream(dir); // IOException
				.newDirectoryStream(dir, "[bcd]*.java"); // IOException
		) {
			for (Path path: dirStream) {
				System.out.println(path.getFileName());
			}
		} // close: IOException
	}
}
