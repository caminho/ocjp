import java.nio.file.*;

public class PathInfo {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\Developer\\git\\ocjp\\ocp\\"
			+ "chapter9\\filespathpaths");
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("getName(1): " + path.getName(1));
		System.out.println("getNameCount: " + path.getNameCount());
		System.out.println("getParent(): " + path.getParent());
		System.out.println("getRoot(): " + path.getRoot());
		System.out.println("subpath(0, 2): " + path.subpath(0, 2));
		System.out.println("subpath(1, 2): " + path.subpath(1, 2));
		System.out.println("toString(): " + path.toString());
	}
}
