package primitives;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfNumbers {

    public static void main(String[] args) {

        // reducing stream
        Stream<Integer> numbers = Stream.of(1, 2, 3);
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2));

        // IntStream sum
        Stream<Integer> numbers2 = Stream.of(1, 2, 3);
        System.out.println(numbers2.mapToInt(x -> x).sum());

        // IntStream average
        IntStream numbers3 = IntStream.of(1, 2, 3);
        OptionalDouble avg = numbers3.average();
        System.out.println(avg.getAsDouble());
    }
}
