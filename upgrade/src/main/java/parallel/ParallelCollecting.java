package parallel;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelCollecting {

    public static void main(String[] args) {

        // parallel collecting
        Stream<String> stream1 = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set1 = stream1
                .collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set1);

        // parallel reduction with collecting
        Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
        // kolektor toSet() ma charakterystykę UNORDERED, ale nie ma CONCURRENT;
        // redukcja nie będzie równoległa
        Set<String> set2 = stream2.collect(  Collectors.toSet()  );
        System.out.println(set2);

        // toConcurrentMap
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map1 =
                ohMy1.collect(Collectors.toConcurrentMap(String::length,
                Function.identity(), (s1, s2) -> s1 + "," + s2));
        System.out.println(map1);
        System.out.println(map1.getClass());

        // groupingByConcurrent
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map2 =
                ohMy2.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map2);
        System.out.println(map2.getClass());
    }
}
