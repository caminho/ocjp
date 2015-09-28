import java.io.*;
import java.nio.file.*;
import java.net.URI;

public class CreatingPath {
	public static void main(String[] args) {
		Path rel = Paths.get("CreatingPath.java");
		System.out.println(rel);		
		Path p1 = Paths.get("C:\\TEMP\\file.txt");
		System.out.println(p1);
		Path p2 = Paths.get("C:", "TEMP\\file.txt");
		System.out.println(p2);
		Path p3 = Paths.get("C:", "TEMP", "file.txt");
		System.out.println(p3);
		System.out.println("p1=p2? " + p1.equals(p2)); 
		System.out.println("p1=p3? " + p1.equals(p3)); 
		
		// dla Unixa sciezka bezwzgledna, dla windows juz nie
		Path pathUnix = Paths.get("/TEMP/file.txt");
		System.out.println(pathUnix);
		
		Path longerSyntax = FileSystems.getDefault().getPath("C:",
			"TEMP", "file.txt");
		System.out.println(longerSyntax);
				
		Path fromUri = Paths.get(URI.create("file:///C:/TEMP/file.txt"));
		System.out.println(fromUri);
	}
}