import java.io.*;

public class TryWithResources {
	
	public void openResourceOldWay() throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(
				new FileReader("MultiCatchTest.java"));
			printFile(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// ...
				}
			}
		}
	}
	
	public void openResourceJava7Way() throws IOException {
		try (FileReader fr = new FileReader("MultiCatchTest.java");
				BufferedReader reader = new BufferedReader(fr)) {
			printFile(reader);
		}
	}
	
	private void printFile(BufferedReader reader) throws IOException {
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
	
	public static void main(String[] args) throws IOException {
		//new TryWithResources().openResourceOldWay();
		new TryWithResources().openResourceJava7Way();
	}
}
