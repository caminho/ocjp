import java.io.*;

public class ExceptionTest {
	public static void main(String[] args) {
		
		try {
			throw new FileNotFoundException();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Koniec");
		}		
		
	}
}

