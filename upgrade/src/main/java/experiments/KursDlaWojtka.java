package experiments;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KursDlaWojtka {

    public static void main(String[] args) {

//        Stream.of("Ala", "Ma", "Kota", "A", "Kot", "Ma", "HIV")
//                .filter(word -> word.startsWith("A"))
//                .map(String::length)
//                .forEach(System.out::println);

        IntStream.rangeClosed(5, 10)
                .filter(x -> x % 2 == 0)
                .reduce((a, b)->a+b)
                .ifPresent(System.out::println);
    }
}
