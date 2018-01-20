package parallel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingParallelStream {

    public static void main(String[] args) {

        // parallel()
        Stream<Integer> stream1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Stream<Integer> parallelStream1 = stream1.parallel();

        // parallelStream()
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> parallelStream2 = numbers.parallelStream();
    }
}
