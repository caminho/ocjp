import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.io.*;

public class ChangeAttrsNewWay {
	public static void main(String[] args) throws IOException {
		Date januaryFirst = new GregorianCalendar(
			2013, Calendar.MAY, 5).getTime();
		System.out.println(januaryFirst);
		Path path = Paths.get("C:\\temp\\file2");
		Files.createFile(path);
		FileTime fileTime = FileTime.fromMillis(
			januaryFirst.getTime());
		Files.setLastModifiedTime(path, fileTime);
		System.out.println(Files.getLastModifiedTime(path));
		Files.delete(path);
	}
}
