package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JavaLinesCounter {

    private static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        /*
        time find /Users/tomek/ideaProjects/ocjp -name "*.java" -exec cat {} \; | wc -l
        7778
        real    0m0.789s
        user    0m0.318s
        sys     0m0.277s
         */

        Path dir = Paths.get("/Users/tomek/ideaProjects");
        try {
            /*
            7780
            Time: 0.398
             */
            long start = System.currentTimeMillis();
            long javaLines = Files.find(dir, Integer.MAX_VALUE,
                    (p, a) -> a.isRegularFile() &&
                            p.toString().endsWith(".java")
                            && !p.toString().contains("ocjp"))
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
