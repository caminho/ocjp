package java8addons;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorsExample {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Cat", true, false));
        animals.add(new Animal("Dog", true, true));

        animals.sort(comparing(Animal::toString).thenComparingInt(Animal::hashCode));
    }
}
