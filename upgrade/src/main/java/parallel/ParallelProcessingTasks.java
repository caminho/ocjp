package parallel;

import java.util.Arrays;

public class ParallelProcessingTasks {

    public static void main(String[] args) {

        // serial example
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .forEach(s -> System.out.print(s + " "));

        // parallel example
        System.out.println("\n----");
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEach(s -> System.out.print(s + " "));

        // parallel example with ordering
        System.out.println("\n----");
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));

        System.out.println("\n----");
    }
}
