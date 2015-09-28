import java.io.IOException;
import java.nio.file.*;

public class CreateFileAndDir {
	public static void createDirectories() {
		Path newDir = Paths.get("newdir");
		Path subDir1 = Paths.get("newdir\\subdir1");
		Path subDir2 = Paths.get("newdir\\subdir1\\subdir2");
		Path file = Paths.get("newdir\\subdir1\\subdir2\\file.txt");
		
		try {
			Files.createDirectory(newDir);
			Files.createDirectory(subDir1);
			Files.createDirectory(subDir2);
			Files.createFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Files.exists(file));
	}
	
	public static void createDirectoriesOneLine() {
		Path dir = Paths.get("newdir2\\subdir1\\subdir2");
		Path file = Paths.get("newdir2\\subdir1\\subdir2\\file.txt");
		
		try {
			Files.createDirectories(dir);
			if (!Files.exists(file)) {
				Files.createFile(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Files.exists(file));
	}
	
	public static void main(String[] args) {
		createDirectories();
		createDirectoriesOneLine();
	}
}
