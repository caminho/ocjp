import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class RemoveClassFiles extends SimpleFileVisitor<Path> {
	
	public FileVisitResult visitFile(Path file, 
			BasicFileAttributes attr) throws IOException {
		System.out.println(file);
		if (file.getFileName().toString().endsWith(".class")) {
			Files.delete(file);
		}
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		Path where = Paths.get("./visit");
		RemoveClassFiles classRemover = new RemoveClassFiles();
		// IOException
		Files.walkFileTree(where, classRemover);
	}
}
