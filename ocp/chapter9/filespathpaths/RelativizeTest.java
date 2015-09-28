import java.nio.file.*;

public class RelativizeTest {
	public static void main(String[] args) {
		Path rootHomeJava = Paths.get("/home/java");
		Path rootUsrLocal = Paths.get("/usr/local");
		Path rootHomeJavaTempMusicMp3 = Paths.get(
			"/home/java/temp/music.mp3");
		Path temp = Paths.get("temp");
		Path tempMusicPdf = Paths.get("temp/music.pdf");
		
		System.out.println("1: " + 
			rootHomeJava.relativize(rootHomeJavaTempMusicMp3));
		System.out.println("2: " + 
			rootHomeJavaTempMusicMp3.relativize(rootHomeJava));
		System.out.println("3: " + 
			rootHomeJava.relativize(rootUsrLocal));
		System.out.println("4: " + 
			temp.relativize(tempMusicPdf));
		System.out.println("5: " + 
			rootHomeJava.relativize(temp)); // BAD
	}
}
