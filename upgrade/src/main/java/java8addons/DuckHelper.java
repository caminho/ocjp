package java8addons;

import java.util.Comparator;

class Duck {
    private int weight;
    private String name;

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

public class DuckHelper {
    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);

        Comparator<Duck> byWeight_more_compact = DuckHelper::compareByWeight;
    }
}
