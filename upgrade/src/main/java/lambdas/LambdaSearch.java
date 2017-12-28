package lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaSearch {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        System.out.println("Animals which can hop");
        print(animals, a -> a.canHop()); // pass class that does check
        System.out.println("Animals which can swim");
        print(animals, a -> a.canSwim());
        print(animals, (a) -> a.canSwim());
        print(animals, (Animal a) -> a.canSwim());
        print(animals, (Animal a) -> {return a.canSwim();});
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) System.out.print(animal + " ");
        }
        System.out.println();
    }
}
