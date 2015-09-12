import java.io.IOException;

class One implements AutoCloseable {
	public void close() throws IOException {
		throw new IOException("Closing");
	}
}

class Bad implements AutoCloseable {
	private String name;
	
	public Bad(String n) { name = n; }
	
	public void close() throws IOException {
		throw new IOException("Closing - " + name);
	}
}

public class SuppressedExceptions {
	
	public static void printExceptions(Exception e) {
		System.err.println("Main exception: " + e.getMessage());
		for (Throwable t: e.getSuppressed()) {
			System.err.println("Suppressed: " + t);
		}
	}
	
	public static void main(String[] args) {
		try (One one = new One()) {
			throw new Exception("Try");
		} catch (Exception e) {
			printExceptions(e);
		}
		System.out.println("---");
		
		try (Bad b1 = new Bad("1"); Bad b2 = new Bad("2")) {
			System.out.println("Do stuff with b1 and b2");
		} catch (Exception e) {
			printExceptions(e);
		}
	}
}
