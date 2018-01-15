package functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExamples {

    public static void main(String[] args) {

        // Consumer examples
        Consumer<String> c1 = (s) -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        c1.accept("hello");
        c2.accept("world");

        // BiConsumer examples

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> c3 = (k, v) -> map.put(k, v);
        BiConsumer<String, Integer> c4 = map::put;
        c3.accept("chicken", 7);
        c4.accept("chick", 1);

        System.out.println(map);

        Map<String, String> map2 = new HashMap<>();
        BiConsumer<String,String> c5 = map2::put;
        BiConsumer<String,String> c6 = (k,v)->map2.put(k,v);

        c5.accept("chicken", "Cluck");
        c6.accept("chick", "Tweep");

        System.out.println(map2);
    }
}
