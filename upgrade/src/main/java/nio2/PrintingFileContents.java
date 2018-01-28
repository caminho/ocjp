package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintingFileContents {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("upgrade.iml"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
