import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class RemoveClassFiles extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(Path file, 
			BasicFileAttributes attr) throws IOException {
		System.out.println("checking: " + file.getFileName() + "|");
		if (file.getFileName().endsWith(".class")) { ///???
			System.out.println("** deleting: " + file.getFileName() + " ***");
			Files.delete(file);
		}
		return FileVisitResult.CONTINUE;
	}
}

public class FileVisitorTest {
	public static void main(String[] args) throws IOException {
			Path where = Paths.get("C:\\temp\\ocp");
			RemoveClassFiles classRemover = new RemoveClassFiles();
			// IOException
			Files.walkFileTree(where, classRemover);
	}
}