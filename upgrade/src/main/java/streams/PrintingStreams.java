package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintingStreams {

    public static void main(String[] args) {

        {
            System.out.println("\n----");
            Stream.of("this", "is", "finite", "stream").forEach(System.out::print);
            // Stream.generate(()->"infinite-").forEach(System.out::print); // PRINTS INFINITELY
        }
        {
            System.out.println("\n----");
            System.out.println(Stream.of("this", "is", "finite", "stream").collect(Collectors.toList()));
            // System.out.println(Stream.generate(()->"infinite-").collect(Collectors.toList())); // HANGS
        }

        {
            System.out.println("\n----");
            Stream.of("this", "is", "finite", "stream").peek(System.out::print).count();
            // Stream.generate(()->"infinite-").peek(System.out::println).count();; // HANGS
        }
        {
            System.out.println("\n----");
            Stream.of("this", "is", "finite", "stream").limit(5).forEach(System.out::print);
            System.out.println();
            Stream.generate(() -> "infinite-").limit(5).forEach(System.out::print); // OK
        }
    }
}
