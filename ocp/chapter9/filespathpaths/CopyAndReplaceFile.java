import java.io.*;
import java.nio.file.*;

public class CopyAndReplaceFile {
	public static void main(String[] args) throws IOException {
		Path source = Paths.get(args[0]);
		Path target = Paths.get(args[1]);
		
		// wyrzuca FileAlreadyExiststException, 
		// jesli plik docelowy istnieje
		// Files.copy(source, target); 
		
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);		
	}
}
