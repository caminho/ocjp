import java.io.*;

public class DeleteRenameTest {
	public static void main(String[] args) {
		// tworzenie katalogu
		File delDir = new File("deldir");
		delDir.mkdir();
		
		// tworzenie pliku w katalogu deldir
		File file1 = new File(delDir, "file1.txt");
		
		// tworzenie pliku w katalogu deldir
		File file2 = new File(delDir, "file2.txt");
		try {
			file1.createNewFile();
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// usuwanie pliku
		System.out.println("Usuwanie pliku file1: " + 
				file1.delete());
		// usuwanie katalogu
		System.out.println("Usuwanie katalogu deldir: " + 
				delDir.delete());
				
		// zmiana nazwy pliku
		File newName = new File(delDir, "newName.txt");
		file2.renameTo(newName);
		
		// zmiana nazwy katalogu
		File newDir = new File("newDir");
		delDir.renameTo(newDir);		
	}
}
