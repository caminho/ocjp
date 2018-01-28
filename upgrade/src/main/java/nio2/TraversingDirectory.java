package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraversingDirectory {

    public static void main(String[] args) {

        Path dir = Paths.get("/Users/tomek/ideaProjects/ocjp/upgrade");
        try {
            Files.walk(dir, 1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
