import java.io.*;
import java.nio.file.*;

public class CopyMoveDelete {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get(args[0]);
		Path target = Paths.get(args[1]);
		
		Files.copy(source, target);
		// Files.delete(target);
		Files.deleteIfExists(target);
		Files.move(source, target);
	}
}