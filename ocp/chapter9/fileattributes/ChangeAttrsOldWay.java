import java.util.*;
import java.io.*;

public class ChangeAttrsOldWay {
	public static void main(String[] args) throws IOException {
		Date januaryFirst = new GregorianCalendar(
			2013, Calendar.JANUARY, 1).getTime();
		File file = new File("C:\\temp\\file1");
		file.createNewFile();
		file.setLastModified(januaryFirst.getTime());
		System.out.println(file.lastModified());
		file.delete();
	}
}
