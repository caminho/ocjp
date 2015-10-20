import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatcher {
	public static void main(String[] args) throws IOException {
		WatchService watcher = FileSystems.getDefault()
			.newWatchService();//IOException
		
		Path dir = Paths.get("C:\\temp");
		//IOException
		dir.register(watcher, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);
		System.out.println("registered");
		
		while (true) {
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException ex) {
				return;
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name());
				System.out.println(kind.type());
				//System.out.println(event.context());
				Path path =  (Path) event.context();
				System.out.println(path);
			}
			key.reset();
		}
	}
}