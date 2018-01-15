package optional;

import java.util.Optional;

public class OptionalExamples {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        long sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.of((double) sum / scores.length);
    }

    private static void threeDigit(Optional<Integer> optional) {
        if (optional.isPresent()) {
            Integer num = optional.get();
            String string = "" + num;
            if (string.length() == 3)
                System.out.println(string);
        }
    }

    private static void threeDigitFunc(Optional<Integer> opt) {
        opt.map(String::valueOf)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    private static Optional<Integer> calculator(String s) {
        if (s == null) {
            return Optional.empty();
        }
        return Optional.of(s.length());
    }

    public static void main(String[] args) {

        Optional<Double> avg = average(1, 2);
        System.out.println(avg);

        if (avg.isPresent()) {
            System.out.println(avg.get());
        }

        // System.out.println(average().get());   // No value present
        // System.out.println(Optional.of(null)); // No value present
        System.out.println(Optional.ofNullable(null));

        System.out.println("---");
        Optional<Double> opt = average(3);
        opt.ifPresent(System.out::println);
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(Math::random));
        System.out.println(opt.orElseThrow(RuntimeException::new));

        System.out.println("---");
        threeDigit(Optional.empty());
        threeDigit(Optional.of(1));
        threeDigit(Optional.of(12));
        threeDigit(Optional.of(123));
        threeDigit(Optional.of(1234));

        System.out.println("---");
        threeDigitFunc(Optional.empty());
        threeDigitFunc(Optional.of(1));
        threeDigitFunc(Optional.of(12));
        threeDigitFunc(Optional.of(123));
        threeDigitFunc(Optional.of(1234));

        System.out.println(Optional.of("hello").map(String::length));

        System.out.println(Optional.of("hello world").flatMap(OptionalExamples::calculator));
    }
}
