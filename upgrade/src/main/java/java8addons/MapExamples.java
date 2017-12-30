package java8addons;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapExamples {

    public static void main(String[] args) {

        Map<String, String> favorites = new HashMap<>();

        favorites.put("Jenny", "Bus tour");
        favorites.put("Tomek", null);
        System.out.println(favorites);

        // putIfAbsent
        System.out.println("\nputIfAbsent");
        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Mickey", "Car");
        favorites.putIfAbsent("Tomek", "Metro");
        System.out.println(favorites);

        // merge
        System.out.println("\nmerge");
        BiFunction<String, String, String> mapper =
                (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Sam", null);

        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        String tom = favorites.merge("Tom", "Skyride", mapper);
        String sam = favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites);
        System.out.println(jenny);
        System.out.println(tom);
        System.out.println(sam);

        System.out.println();
        mapper = (v1, v2) -> null;
        favorites.clear();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Bus Tour");
        favorites.put("Sam", null);
        favorites.merge("Jenny", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites);

        // computeIfPresent
        System.out.println("\ncomputeIfPresent");
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Jenny", 1);
        BiFunction<String, Integer, Integer> countMapper = (k,v) -> v+1;

        Integer jennyCount = counts.computeIfPresent("Jenny", countMapper);
        Integer samCount = counts.computeIfPresent("Sam", countMapper);
        System.out.println(counts); // {Jenny=2}
        System.out.println(jennyCount); // 2
        System.out.println(samCount); // null

        // computeIfAbsent
        System.out.println("\ncomputeIfAbsent");
        counts.clear();
        counts.put("Jenny", 15);
        counts.put("Tom", null);
        Function<String, Integer> functionMapper = (k) -> 1;
        jennyCount = counts.computeIfAbsent("Jenny", functionMapper);
        Integer tomCount = counts.computeIfAbsent("Tom", functionMapper);
        samCount = counts.computeIfAbsent("Sam", functionMapper);
        System.out.println(counts);
        System.out.println(jennyCount);
        System.out.println(tomCount);
        System.out.println(samCount);

        counts.clear();
        counts.put("Jenny", 1);

        counts.computeIfPresent("Jenny", (k, v) -> null);
        counts.computeIfAbsent("Sam", k -> null);
        System.out.println(counts);
    }
}
