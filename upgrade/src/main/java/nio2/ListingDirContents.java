package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDirContents {

    public static void main(String[] args) {

        Path path = Paths.get(".");
        try {
            Files.list(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(Path::toAbsolutePath)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
