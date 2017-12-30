package java8addons;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

    public static void main(String[] args) {

        Map<String, String> favorites = new HashMap<>();

        favorites.put("Jenny", "Bus tour");
        favorites.put("Tomek", null);
        System.out.println(favorites);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Mickey", "Car");
        favorites.putIfAbsent("Tomek", "Metro");
        System.out.println(favorites);
    }
}
