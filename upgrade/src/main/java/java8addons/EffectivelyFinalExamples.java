package java8addons;

import java.util.function.Predicate;

public class EffectivelyFinalExamples {

    public static void main(String[] args) {

        String a = "Sd";

        Predicate<String> lambda = (s -> a.isEmpty());
        lambda.test("dd");
    }
}
