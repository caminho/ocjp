package parallel;

import java.util.Arrays;

public class IndependentOperations {

    public static void main(String[] args) {

        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        System.out.println("----");

        Arrays.asList("jackal", "kangaroo", "lemur", "bat")
                .parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

        System.out.println("----");

        Arrays.asList("jackal", "kangaroo", "lemur", "bat", "hakuna", "matata", "simba", "leon")
                .parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEachOrdered(System.out::println);
    }
}
