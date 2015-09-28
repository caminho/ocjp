import java.io.*;

public class MkDirTest {
	public static void main(String[] args) {
		File myDir = new File("mydir");
		//myDir.mkdir();
		File myFile = new File(myDir, "myFile.txt");
		
		PrintWriter pw = null;
		try {
			myFile.createNewFile();
			pw = new PrintWriter(myFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (pw != null) {
			pw.println("new stuff");
			pw.flush();
			pw.close();
		}
	}
}