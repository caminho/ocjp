package functional;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String[] args) {

        // Predicate examples
        Predicate<String> p1 = s -> s.isEmpty();
        Predicate<String> p2 = String::isEmpty;

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));

        // BiPredicate examples
        BiPredicate<String, String> p3 = (s, prefix) -> s.startsWith(prefix);
        BiPredicate<String, String> p4 = String::startsWith;

        System.out.println(p3.test("hello", "hell"));
        System.out.println(p4.test("tata", "ma"));

        // Default methods
        Predicate<String> brown = s -> s.toLowerCase().contains("brown");
        Predicate<String> egg = s -> s.toLowerCase().contains("egg");

        Predicate<String> brownEgg = egg.and(brown);
        Predicate<String> otherEgg = egg.and(brown.negate());

        System.out.println(brownEgg.test("Brown eggs on my plate"));
    }
}
