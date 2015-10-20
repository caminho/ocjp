import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class PrintDirVisitor extends SimpleFileVisitor<Path> {
	
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		System.out.println("pre: " + dir);
		if (dir.getFileName().toString().equals("cdir")) {
			System.out.println("skipping siblings");
			return FileVisitResult.SKIP_SIBLINGS;
		}
		//if (dir.getFileName().toString().equals("edir")) {
		//	System.out.println("terminating");
		//	return FileVisitResult.TERMINATE;
		//}
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult postVisitDirectory(Path dir, IOException e) {
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file: " + file);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException e) {
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("./visit");
		Files.walkFileTree(dir, new PrintDirVisitor());
	}
}
