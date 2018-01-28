package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PrintingLogContents {

    public static void main(String[] args) {

        Path logFile = Paths.get("file.log");
        try {
            List<String> warnings = Files.lines(logFile)
                    .filter(s -> s.startsWith("WARN"))
                    .map(s -> s.substring(5))
                    .collect(Collectors.toList());
            System.out.println(warnings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
