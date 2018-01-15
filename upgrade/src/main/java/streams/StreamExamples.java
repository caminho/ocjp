package streams;

import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class StreamExamples {

    public static void main(String[] args) {

        Stream.of("hello", "to ja", "zmykam")
                .collect(groupingBy(String::length, joining(",")))
                .forEach((k, v) -> out.println(String.format("%d:\t%s", k, v)));
    }
}
