package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PipelineExamples {

    public static void main(String[] args) {

        /*
        Let’s say that we wanted to get the  first two names
         alphabetically that are four characters long.
         */

        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        // In Java 7, we’d have to write something like the following:
        {
            List<String> filtered = new ArrayList<>();
            for (String name : list) {
                if (name.length() == 4) {
                    filtered.add(name);
                }
            }
            Collections.sort(filtered);
            List<String> result = new ArrayList<>();
            int count = 2;
            for (String name : filtered) {
                result.add(name);
                if (--count == 0) {
                    break;
                }
            }
            System.out.println(result);
        }

        // In Java 8:
        {
            List<String> result = list.stream()
                    .filter(s -> s.length() == 4)
                    .sorted().limit(2)
                    .collect(toList());
            System.out.println(result);
        }

        // What do you think the following does?
        {
            Stream.generate(() -> "Elsa")
                    .filter(n -> n.length() == 4)
                    // .sorted().limit(2) // HANGS
                    .limit(2).sorted() // depends on input
                    .forEach(System.out::println);
        }

        // Now what do you think this prints?
        {
            System.out.println("\n----------");
            Stream.iterate(1, n -> n + 1)
                    .limit(5)
                    .peek(System.out::print)
                    .filter(x -> x % 2 == 1)
                    .forEach(System.out::print); //  11233455
        }

        // Now what do you think this prints?
        {
            System.out.println("\n----------");
            Stream.iterate(1, n -> n + 1)
                    .filter(x -> x % 2 == 1)
                    .limit(5)
                    .forEach(System.out::print); //  13579
        }

        // Now what do you think this prints?
        {
            System.out.println("\n----------");
            Stream.iterate(1, n -> n + 1)
                    .filter(x -> x % 2 == 1)
                    .peek(System.out::print)
                    .limit(5)
                    .forEach(System.out::print); //  1133557799
        }
    }
}
