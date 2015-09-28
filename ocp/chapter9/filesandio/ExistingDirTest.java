import java.io.*;

public class ExistingDirTest {
	public static void main(String[] args) {
		File existingDir = new File("existingDir");
		System.out.println(existingDir.isDirectory());
		
		File existingDirFile = new File(existingDir, 
				"existingDirFile.txt");
		System.out.println(existingDirFile.isFile());
		
		try (FileReader fr = new FileReader(existingDirFile);
				BufferedReader br = new BufferedReader(fr)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}