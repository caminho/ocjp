package primitives;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        // empty streams
        System.out.println("----");
        DoubleStream emptyDoubleStream = DoubleStream.empty();
        IntStream emptyIntStream = IntStream.empty();
        LongStream emptyLongStream = LongStream.empty();
        System.out.println(emptyLongStream);

        // static factories
        System.out.println("----");
        DoubleStream oneDouble = DoubleStream.of(12.0);
        IntStream oneInt = IntStream.of(3);
        LongStream oneLong = LongStream.of(12L);

        DoubleStream manyDoubles = DoubleStream.of(2.0, 45.0, 22.1);
        manyDoubles.forEach(System.out::println);

        // generating
        System.out.println("----");
        DoubleStream randomDoubles = DoubleStream.generate(Math::random).limit(5);
        randomDoubles.forEach(System.out::println);

        DoubleStream fractions = DoubleStream.iterate(10, n -> n / 2.0);
        fractions.limit(5).forEach(System.out::println);

        // random
        System.out.println("----");
        Random r = new Random();
        r.doubles(5, 10.0, 20.0).forEach(System.out::println);
        r.ints(5, 10, 15).forEach(System.out::println);

        // counting
        System.out.println("----");
        IntStream intStream = IntStream.iterate(1, n -> n + 1).limit(5);
        intStream.forEach(System.out::println);

        System.out.println("----");
        IntStream.range(1, 6).forEach(System.out::println);

        System.out.println("----");
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        // mapping
        System.out.println("----");
        Stream<String> animals = Stream.of("Penguin", "Fish");
        IntStream lengths = animals.mapToInt(s->s.length());
        IntConsumer printAll = System.out::println;
        lengths.forEach(printAll);
    }
}
