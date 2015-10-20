import java.util.*;
import java.nio.file.*;

public class PathMatcherTest {
	
	public static void testMatch(String pathStr, String pattern) {
		Path path = Paths.get(pathStr);
		PathMatcher matcher = FileSystems.getDefault()
			.getPathMatcher(pattern);
		System.out.println("path: " + pathStr + ", pattern: " + pattern
			+ ", result: " + matcher.matches(path));
	}
	
	public static void main(String[] args) {
		testMatch("file.txt", "glob:*.txt");
		testMatch("/com/java/One.java", "glob:*.java");
		testMatch("/com/java/One.java", "glob:**/*.java");
		testMatch("/com/java/One.java", "glob:*");
		testMatch("/com/java/One.java", "glob:**");
	}
}