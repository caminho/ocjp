import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DosAttributes {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("dosfile.txt");
		Files.createFile(path);
		
		// IOException
		Files.setAttribute(path, "dos:hidden", true);
		Files.setAttribute(path, "dos:readonly", true);
		
		DosFileAttributes dos = null;
		
		// IOException
		dos = Files.readAttributes(path, DosFileAttributes.class);
		
		System.out.println("create: " + dos.creationTime());
		System.out.println("access: " + dos.lastAccessTime());
		System.out.println("modify: " + dos.lastModifiedTime());
		System.out.println("directory: " + dos.isDirectory());
		System.out.println("hidden: " + dos.isHidden());
		System.out.println("readonly: " + dos.isReadOnly());
		System.out.println("----------------");
		
		
		// IOException
		Files.setAttribute(path, "dos:hidden", false);
		Files.setAttribute(path, "dos:readonly", false);
		// IOException
		dos = Files.readAttributes(path, DosFileAttributes.class);
		System.out.println("hidden: " + dos.isHidden());
		System.out.println("readonly: " + dos.isReadOnly());
		
		Files.delete(path);
	}
}