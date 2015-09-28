import java.io.*;

public class DirListTest {
	public static void main(String[] args) {
		File thisDir = new File(".");
		String[] files = thisDir.list();
		for (String fileName: files) {
			System.out.println("Found: " + fileName);
		}
	}
}
