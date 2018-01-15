package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples {

    public static void main(String[] args) {

        // joining example
        System.out.println("------");
        String allAnimals = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.joining(", "));
        System.out.println(allAnimals);

        // averaging example
        System.out.println("------");
        Double avgLength = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.averagingInt(String::length));
        System.out.println(avgLength);

        // summing example
        System.out.println("------");
        int lengthSum = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.summingInt(String::length));
        System.out.println(avgLength);

        // toCollection example
        System.out.println("------");
        TreeSet<String> setOfAnimals = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(setOfAnimals);

        // minBy example
        System.out.println("------");
        Stream.of("lions", "tigers", "bears")
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // toMap examples
        System.out.println("------");
        Map<String, Integer> animalLengths = Stream.of("lions", "tigers", "bears")
                // .collect(Collectors.toMap(s -> s, s -> s.length()));
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(animalLengths);

        Map<Integer, String> lengthsToAnimals = Stream.of("lions", "tigers", "bears")
                // java.lang.IllegalStateException: Duplicate key lions
                // .collect(Collectors.toMap(String::length, k -> k)); // BAD
                .collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(lengthsToAnimals);
        System.out.println(lengthsToAnimals.getClass());

        Map<Integer, String> lengthsToAnimalsTreeMap = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.toMap(
                        String::length,
                        Function.identity(),
                        (s1, s2) -> s1 + ", " + s2, // mergeFunction
                        TreeMap::new // mapSupplier
                ));
        System.out.println(lengthsToAnimalsTreeMap);
        System.out.println(lengthsToAnimalsTreeMap.getClass());

        // groupingBy example
        System.out.println("------");
        Map<Integer, List<String>> animalListsGroupedByLength = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length));
        System.out.println(animalListsGroupedByLength);

        Map<Integer, Set<String>> animalsSetsGroupedByLength = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(animalsSetsGroupedByLength);

        System.out.println(Stream.of("lions", "tigers", "bears")
                .collect(Collectors.groupingBy(String::length, Collectors.joining(",")))
        );

        TreeMap<Integer, Set<String>> animalsSetsGroupedByLengthToTreeMap =
                Stream.of("lions", "tigers", "bears")
                        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(animalsSetsGroupedByLengthToTreeMap);

        TreeMap<Integer, List<String>> animalsListsGroupedByLengthToTreeMap =
                Stream.of("lions", "tigers", "bears")
                        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(animalsListsGroupedByLengthToTreeMap);

        TreeMap<Integer, String> animalsJoinedGroupedByLengthToTreeMap =
                Stream.of("lions", "tigers", "bears")
                        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.joining(",")));
        System.out.println(animalsJoinedGroupedByLengthToTreeMap);


        Map<Integer, Long> countAnimalsGroupedByLength =
                Stream.of("lions", "tigers", "bears")
                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(countAnimalsGroupedByLength);

        // partitioningBy examples
        System.out.println("------");
        Map<Boolean, List<String>> animalsPartitionedByLength = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(animalsPartitionedByLength);

        Map<Boolean, Set<String>> animalsPartitionedToSetByLength = Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.toSet()));
        System.out.println(animalsPartitionedToSetByLength);

        Map<Boolean, Double> animalsPartitionedByLengthToAvgLength =
                Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.averagingInt(String::length)));
        System.out.println(animalsPartitionedByLengthToAvgLength);

        Map<Boolean, Long> countAnimalsPartitionedByLength =
                Stream.of("lions", "tigers", "bears")
                .collect(Collectors.partitioningBy(s -> s.length() <= 5, Collectors.counting()));
        System.out.println(countAnimalsPartitionedByLength);

        // mapping examples
        System.out.println("------");
        Map<Integer, Optional<Character>> animalsGroupedByLengthToSmallestFirstLetter =
                Stream.of("lions", "tigers", "bears").collect(
                Collectors.groupingBy(String::length,
                        Collectors.mapping((String s) -> s.charAt(0),
                                Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(animalsGroupedByLengthToSmallestFirstLetter);

    }
}
