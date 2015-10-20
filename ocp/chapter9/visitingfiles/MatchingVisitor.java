import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class MatchingVisitor extends SimpleFileVisitor<Path> {
	
	private PathMatcher matcher = FileSystems.getDefault()
		.getPathMatcher("glob:**/*.class");
	
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if (matcher.matches(file)) {
			System.out.println(file);
		}
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("."), new MatchingVisitor());
	}
}
