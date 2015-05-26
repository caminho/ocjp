import java.io.*;

public class ReadData {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("myfile.txt", "r");
			byte[] b = new byte[1000];
			raf.readFully(b, 0, 1000);
		} 
		//catch (IOException e) {    error: exception FileNotFoundException has already been caught
		//	System.err.println("IO Exception");  	zła kolejność! FileNotFoundException musi być
		//	System.err.println(e.toString());	przed IOException
		//	e.printStackTrace();
		//} 
		catch (FileNotFoundException e) {
			System.err.println("File not found");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("IO Exception");
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
}

