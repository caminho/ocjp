import java.nio.file.*;

public class NormalizationTest {
	public static void normalizePath(String strPath) {
		Path path = Paths.get(strPath);
		System.out.println("path: " + path);
		System.out.println("norm: " + path.normalize());
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		normalizePath("/a/b/c/../../d/");
		normalizePath("/a/./././b/c/");
		normalizePath("/a/b/c/../../");
		normalizePath("/a/b/c/..");
		normalizePath("/../../d/");
		normalizePath("../../d/");
		normalizePath(".file");
		normalizePath("./");
	}
}