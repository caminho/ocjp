import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class BasicAttributes {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("file.txt");
		BasicFileAttributes basic = null;
		// IOException
		basic = Files.readAttributes(path, BasicFileAttributes.class);
		
		System.out.println("create: " + basic.creationTime());
		System.out.println("access: " + basic.lastAccessTime());
		System.out.println("modify: " + basic.lastModifiedTime());
		System.out.println("directory: " + basic.isDirectory());
		
		// zmiana czasu modyfikacji
		FileTime now = FileTime.fromMillis(System.currentTimeMillis());
		BasicFileAttributeView basicView = Files.getFileAttributeView(
			path, BasicFileAttributeView.class);
		try {
			basicView.setTimes(now, null, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("-------------");
		// IOException
		basic = Files.readAttributes(path, BasicFileAttributes.class);
		
		System.out.println("create: " + basic.creationTime());
		System.out.println("access: " + basic.lastAccessTime());
		System.out.println("modify: " + basic.lastModifiedTime());
		System.out.println("directory: " + basic.isDirectory());
		
	}
}