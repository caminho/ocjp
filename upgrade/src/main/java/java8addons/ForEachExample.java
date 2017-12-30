package java8addons;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

    public static void main(String[] args) {

        List<String> cats = Arrays.asList("Annie", "Ripley");

        for (String cat : cats) {
            System.out.println(cat);
        }
        System.out.println("---");

        cats.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("---");

        cats.forEach(cat -> System.out.println(cat));
        System.out.println("---");

        cats.forEach(System.out::println);
    }
}
