package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class IntermediateOperations {

    public static void main(String[] args) {

        // filter example
        Stream<String> stream1 = Stream.of("monkey", "ape", "bonobo");
        stream1.filter(s -> s.startsWith("m")).forEach(System.out::println);

        // distinct example
        System.out.println("---");
        Stream<String> stream2 = Stream.of("hello", "world", "hello", "again");
        stream2.distinct().forEach(System.out::println);

        // limit / skip examples
        System.out.println("---");
        Stream<Integer> stream3 = Stream.iterate(1, n -> n + 1);
        stream3.skip(5).limit(2).forEach(System.out::println);

        // map example
        System.out.println("---");
        Stream<String> stream4 = Stream.of("monkey", "ape", "bonobo");
        stream4.map(String::length).forEach(System.out::println);

        // flatMap examples
        System.out.println("---");
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("one");
        List<String> two = Arrays.asList("two", "three");

        List<String> listFlatten = Stream.of(zero, one, two)
                .flatMap((List<String> strings) -> strings.stream())   // .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(listFlatten);

        List<Set<String>> sets = new ArrayList<>();
        sets.add(setOf("1", "2", "2", "3"));
        sets.add(setOf());
        sets.add(setOf("1", "4", "5"));
        listFlatten = sets.stream().flatMap(Set::stream).collect(Collectors.toList());
        System.out.println(listFlatten);

        // sorted examples
        System.out.println("---");
        Stream<String> stream5 = Stream.of("brown-", "bear-");
        stream5.sorted().forEach(System.out::print);
        System.out.println();
        Stream<String> stream6 = Stream.of("ape-", "brown-", "bear-");
        stream6.sorted(Comparator.reverseOrder()).forEach(System.out::print);   // albo: Collections.reverseOrder()

        // peek examples
        System.out.println("---");
        Stream<String> stream7 = Stream.of("brown bear", "grizzly", "black bear");
        long bearsCount = stream7
                .filter(s -> s.startsWith("b"))
                .peek(System.out::println)
                .count();
        System.out.println(bearsCount);

        System.out.println("---");
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');

        StringBuilder builder = new StringBuilder();
        Stream.of(numbers, letters)
                // .peek(l->l.remove(0))  // BAD CODE
                .peek(builder::append)
                .map(List::size)
                .forEach(System.out::print);
        System.out.println(builder);
    }

    private static <T> Set<T> setOf(T... elements) {
        return Stream.of(elements).collect(toSet());
    }
}
