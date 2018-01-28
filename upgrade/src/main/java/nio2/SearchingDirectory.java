package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchingDirectory {

    private static final long DATE_FILTER = 1420070400000L;

    public static void main(String[] args) {

        Path path = Paths.get("/Users/tomek/ideaProjects/ocjp/upgrade");
        try {
            Files.find(path, 10,
                    (p,a)-> p.toString().endsWith(".java") &&
                            a.lastModifiedTime().toMillis() > DATE_FILTER)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
