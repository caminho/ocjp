import java.io.*;

public class Writer3 {
	public static void main(String[] args) {
		File file = new File("fileWrite3.txt");
		
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println("howdy");
			pw.println("folks");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}