package primitives;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveOptionals {

    public static void main(String[] args) {

        // OptionalDouble
        IntStream ints = IntStream.rangeClosed(1, 10);
        OptionalDouble avg = ints.average();

        avg.ifPresent(System.out::println);
        if (avg.isPresent()) {
            System.out.println(avg.getAsDouble());
        }
        System.out.println(avg.orElseGet(() -> Double.NaN));

        // primitive streams methods
        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();
        System.out.println(sum);

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
        OptionalDouble min = doubles.limit(5).min();
        System.out.println(min);
    }
}
