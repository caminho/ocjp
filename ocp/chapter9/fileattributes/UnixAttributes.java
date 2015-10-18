import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class UnixAttributes {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("unixfile");
		Files.createFile(path);
		
		PosixFileAttributes posix = Files.readAttributes(path,
			PosixFileAttributes.class);
		
		Set<PosixFilePermission> perms = PosixFilePermissions
			.fromString("rw-r--r--");
		Files.setPosixFilePermissions(path, perms);
		System.out.println(posix.permissions());
		System.out.println(posix.group());
		
		Files.delete(path);
	}
}