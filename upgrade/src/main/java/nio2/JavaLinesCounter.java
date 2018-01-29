package nio2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaLinesCounter {

    private static Stream<String> lines(Path p) {
        try {
            return Files.lines(p, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        /*
        $ time find /Users/tomek/ideaProjects -name "*.java" -exec cat {} \; | wc -l
          185925

        real    0m11.082s
        user    0m4.356s
        sys     0m4.123s
         */

        Path dir = Paths.get("/Users/tomek/ideaProjects");
        try {
            /*
            186220
            Time: 7.519
             */
            long start = System.currentTimeMillis();
            long javaLines = Files.find(dir, Integer.MAX_VALUE,
                    (p, a) -> a.isRegularFile() && p.toString().endsWith(".java")).parallel()
                    .flatMap(JavaLinesCounter::lines)
                    .count();
            long duration = System.currentTimeMillis() - start;
            System.out.println(javaLines);
            System.out.println(String.format("Time: %.5s", duration / 1000.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
