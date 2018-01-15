package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        // factories
        Stream<String> empty = Stream.empty();
        Stream<String> singleValue = Stream.of("hello");
        Stream<String> multipleValue = Stream.of("hello", "my", "pretty", "world");

        // collections
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromCollection = list.stream();
        Stream<String> fromCollectionParallel = list.parallelStream();

        // generating values
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    }
}
