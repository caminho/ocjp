package functional;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExamples {

    public static void main(String[] args) {

        // UnaryOperator example
        UnaryOperator<String> o1 = s -> s.toLowerCase();
        UnaryOperator<String> o2 = String::toLowerCase;

        System.out.println(o1.apply("HIP HIP HURRA"));
        System.out.println(o2.apply("HIP HIP HURRA"));

        // BinaryOperator example
        BinaryOperator<String> o3 = (s1, s2) -> s1.concat(s2);
        BinaryOperator<String> o4 = String::concat;

        System.out.println(o3.apply("hi", " mr President"));
        System.out.println(o4.apply("hello", " my friend"));
    }
}
