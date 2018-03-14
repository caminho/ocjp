package experiments;

import java.time.LocalDateTime;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Experiments {
    interface Account {

        default String getId () {
            return "1";
        }
    }

    interface BankAccount extends Account {
        default String getId() {
            return Account.super.getId();
        }
    }

    static class Book {
        String title;
        String author;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    interface A {
        void a();
    }

    interface B extends A {
        default void a() {}
    }

    class C implements A,B {

//        public void a(){}
    }

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4).collect(Collectors.mapping(x->x, Collectors.toList()));

//        ObjIntConsumer<Object> objIntConsumer = (a, b) -> {
//            System.out.println(a+b);
//        };
//        objIntConsumer.accept(22, 5);

        LocalDateTime localDateTime = LocalDateTime.parse("2015-02-27t01:22");
        System.out.println(localDateTime);

        UnaryOperator<Integer> op1 = i -> i*2;
        UnaryOperator<Integer> op2 = i -> i*3;
        Function<Integer, Integer> op3 = op1.compose(op2);
        System.out.println(op3.apply(2));

        IntUnaryOperator op4 = i -> i*2;
        IntUnaryOperator op5 = i -> i*3;
        IntUnaryOperator op6 = op4.andThen(i -> i*3);
        System.out.println(op6.applyAsInt(2));

        Integer i = 5;
        Double d = 5.0;

        int ii = 3;
        double dd = 3.0;

        i = ii;
        i = (int)dd;
//        i = (int)d;

        ii = i;
        ii = (int)dd;

        dd = i;

        double principle = 100;
        int interestrate = 5;
        double amount = compute(principle, x -> x * interestrate);


        Book b1 = new Book();
        Supplier<String> sup = b1::getAuthor;
        String name = sup.get();

        Function<Integer, Integer> integerIntegerFunction = ((Integer) 150)::compareTo;


        UnaryOperator<String> bif =
                "Hello "::concat;
        System.out.println(
                ((UnaryOperator<String>)"Hello "::concat).apply("world!"));

        System.out.println(2.1 % 2.2);
    }

    private static double compute(double base, Function<Integer, Integer> func) {
        return func.apply((int)base);
    }
}
