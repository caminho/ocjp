package java8addons;

import java.util.function.Predicate;

public class EffectivelyFinalExamples {

    int ii = 45;

    public static void main(String[] args) {

        String a = "Sd";

        Predicate<String> lambda = (s -> a.isEmpty());
        lambda.test("dd");
    }

    public  void inner() {
        int ai = 15;

        class Inner {
            public Inner() {
                System.out.println(ai + ii);
            }
        }
    }
}
