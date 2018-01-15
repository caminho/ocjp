package functional;

import java.util.function.BiFunction;
import java.util.function.Function;


interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class FunctionExamples {
    public static void main(String[] args) {

        // Function example
        Function<String, Integer> f1 = s -> s.length();
        Function<String, Integer> f2 = String::length;

        System.out.println(f1.apply("tomek"));
        System.out.println(f2.apply("piotrek"));

        // BiFunction example
        BiFunction<String, String, String> f3 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> f4 = String::concat;

        System.out.println(f3.apply("hello ", "world"));
        System.out.println(f4.apply("I am ", "here"));

        /*
        public static String valueOf(char data[], int offset, int count) {
            return new String(data, offset, count);
        }
         */
        // Own function interface example
        TriFunction<char[], Integer, Integer, String> f5 = String::valueOf;
        TriFunction<char[], Integer, Integer, String> f6 = (d,o,c)->String.valueOf(d,o,c);

        System.out.println(f5.apply(new char[]{'t','o','m','e','k'}, 1, 3));
    }
}
