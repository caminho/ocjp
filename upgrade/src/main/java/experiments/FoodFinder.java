package experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FoodFinder {

    public static void main(String[] args) throws IOException {

        Files.find(Paths.get("dir"), Integer.MAX_VALUE, (p, a) -> !a.isDirectory())
                .filter(path -> contains(path,
                        line -> line.contains("pomidory")))
                .forEach(System.out::println);
    }

    private static boolean contains(Path path, Predicate<String> predicate) {
        try (Stream<String> content = Files.lines(path)) {
            return content.anyMatch(predicate);
        } catch (IOException e) {
            return false;
        }
    }
}
