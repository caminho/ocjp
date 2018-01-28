package java8addons;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Duck implements Comparable<Duck> {
    private int weight;
    private String name;

    Duck(){}

    Duck(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public static String helloWorld() {
        return "hello world";
    }

    public String addTwoStrings(String a, String b) {
        return a + b;
    }


    @Override
    public int compareTo(Duck o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    class Leg {
        String legNumber;

        Leg(){}

        public Leg(String legNumber) {
            this.legNumber = legNumber;
        }
    }

    static class StaticLeg {
        String legNumber;

        StaticLeg(){}

        public StaticLeg(String legNumber) {
            this.legNumber = legNumber;
        }
    }
}

interface DuckMethod {
    void duckMethod(Duck duck, String a, String b);
}

public class MethodReferences {

    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }

    public static void main(String[] args) {
        Comparator<Duck> byWeight = (d1, d2) -> MethodReferences.compareByWeight(d1, d2);

        Comparator<Duck> byWeight_more_compact = MethodReferences::compareByWeight;

        // referencja do metody statycznej
        Consumer<List<String>> sortLambda = list -> Collections.sort(list);
        Consumer<List<String>> sortRef = Collections::sort;

        // referencja do metody konkretnej instancji
        String str = "abc";
        Predicate<String> prefixLambda = prefix -> str.startsWith(prefix);
        Predicate<String> prefixRef = str::startsWith;

        System.out.println(str + " start with a: " + prefixLambda.test("a"));
        System.out.println(str + " start with a: " + prefixRef.test("a"));


        Supplier<String> helloStatic = Duck::helloWorld;
        Duck duck = new Duck();
        Supplier<String> getNameRef = duck::getName;
        // ERROR: Error:(59, 51) java: invalid method reference static bound method reference
        // Supplier<String> helloInstance  = duck::helloWorld;

        // referencja do metody dowolnej instancji

        Predicate<String> isEmptyLambda = s -> s.isEmpty();
        Predicate<String> isEmptyRef = String::isEmpty;

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("abc");
        strings.add("hello");

        strings.removeIf(isEmptyRef);

        Duck d = new Duck();

        DuckMethod duckMethodLambda = (duck1, a, b) -> duck1.addTwoStrings(a, b);
        DuckMethod duckMethodRef = Duck::addTwoStrings;


        List<Duck> ducks = Arrays.asList(
                new Duck("Spocky"),
                new Duck("Daffy"),
                new Duck("Anny"));

        Collections.sort(ducks);
        Collections.sort(ducks, (o1, o2) -> o1.compareTo(o2));
        Collections.sort(ducks, Duck::compareTo);
        System.out.println(ducks);

        // referencja do konstruktora

        Supplier<Duck> newDuckLambda = () -> new Duck();
        Supplier<Duck> newDuckRef = Duck::new;

        Duck leggedDuck = new Duck();
        Supplier<Duck.Leg> legSupplierLambda = () -> leggedDuck.new Leg();

        Supplier<Duck.StaticLeg> legSupplierRef = Duck.StaticLeg::new;

        SupplierArg<Duck, String> duckWithName = Duck::new;

        Function<String, Duck> nameToDuck = Duck::new;
    }

    interface SupplierArg<T,U> {
        T supply(U u);
    }
}
