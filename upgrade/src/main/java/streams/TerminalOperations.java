package streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {

        // Count example
        Stream<String> stream1 = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(stream1.count());

        // Min example
        Stream<String> stream2 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> minOpt = stream2.min((s1, s2) -> s1.length() - s2.length());
        minOpt.ifPresent(System.out::println);

        // Max example
        Stream<String> stream3 = Stream.empty();
        Optional<String> maxOpt = stream3.max((s1, s2) -> 0);
        System.out.println(maxOpt.isPresent());

        // findAny / findFirst examples
        Stream<String> stream4 = Stream.of("monkey", "gorilla", "bonobo");
        stream4.findAny().ifPresent(System.out::println);
        Stream<String> stream5 = Stream.generate(() -> "chimp");
        stream5.findFirst().ifPresent(System.out::println);

        // allMatch / anyMatch / noneMatch examples
        Predicate<String> pred = s -> Character.isLetter(s.charAt(0));
        List<String> list1 = Arrays.asList("monkey", "2", "chimp");
        System.out.println(list1.stream().allMatch(pred));
        System.out.println(list1.stream().anyMatch(pred));
        System.out.println(list1.stream().noneMatch(pred));
        Stream<String> stream6 = Stream.generate(() -> "chimp");
        System.out.println(stream6.noneMatch(pred));

        // forEach example
        Stream<String> stream7 = Stream.of("monkey", "ape", "bonobo");
        stream7.forEach(System.out::println);

        // reduce examples
        System.out.println("---");
        Stream<String> stream8 = Stream.of("w", "o", "l", "f");
        // System.out.println(stream8.reduce("big", (s1,s2)->s1.concat(s2)));
        System.out.println(stream8.reduce("big", String::concat));
        Stream<Integer> stream9 = Stream.empty(); // Stream.of(2, 5, 7);
        System.out.println(stream9.reduce(1, (n1, n2) -> n1 * n2));
        Stream<Integer> stream10 = Stream.of(2, 5, 7);
        stream10.reduce((n1, n2) -> n1 * n2).ifPresent(System.out::println);

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> stream11 = Stream.empty();
        Stream<Integer> stream12 = Stream.of(3);
        Stream<Integer> stream13 = Stream.of(3, 5, 6);
        stream11.reduce(op).ifPresent(System.out::println);
        stream12.reduce(op).ifPresent(System.out::println);
        stream13.reduce(op).ifPresent(System.out::println);

        Stream<Integer> stream14 = Stream.of(3, 5, 6);
        System.out.println(stream14.reduce(1, op, op));

        Stream<Integer> reduceToBigDecimal = Stream.of(2, 5, 8);
        System.out.println(reduceToBigDecimal.reduce(BigDecimal.ONE,
                (b, d) -> b.multiply(BigDecimal.valueOf(d)),
                BigDecimal::multiply));

        Integer lengthSum = Stream.of("hello", "world", "I", "am", "back")
                .reduce(0, (s1, s2) -> s1 + s2.length(), (s1, s2) -> s1 + s2);
        System.out.println(lengthSum);

        System.out.println(Stream.of("hello", "world", "I", "am", "back")
                .collect(Collectors.summingInt(String::length)));

        System.out.println(Stream.of("hello", "world", "I", "am", "back")
                .mapToInt(String::length).sum());

        // collect examples
        System.out.println("---");
        Stream<String> stream15 = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream15.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);
        System.out.println(word);

        Stream<String> stream16 = Stream.of("w", "o", "l", "f");
        Set<String> wordSet = stream16.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(wordSet);

        Stream<String> stream17 = Stream.of("w", "o", "l", "f");
        wordSet = stream17.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(wordSet);

        Stream<String> stream18 = Stream.of("w", "o", "l", "f");
        wordSet = stream18.collect(Collectors.toSet());
        System.out.println(wordSet);
    }
}
