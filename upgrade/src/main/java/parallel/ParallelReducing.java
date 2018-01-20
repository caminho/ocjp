package parallel;

import java.util.Arrays;

public class ParallelReducing {

    public static void main(String[] args) {

        // reduce
        String wolf = Arrays.asList('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce("", (s, c) -> s + c, (s1, s2) -> s1 + s2);
        System.out.println(wolf);

        // non associative operator
        Integer diff = Arrays.asList(1, 2, 3, 4, 5, 6)
                // .stream()
                .parallelStream()
                .reduce(0, (a, b) -> {
                    System.out.printf("diff (%d) - (%d) = %d\n", a, b, a-b);
                    return a - b;});
        System.out.println(diff);

        // invalid identity
        String wolfStr = Arrays.asList("w", "o", "l", "f")
                //.stream()
                .parallelStream()
                .reduce("!", String::concat);
        System.out.println(wolfStr);
    }
}
