package experiments;

import java.util.function.*;
import java.util.stream.Stream;

public class LambdaTests {

    public static void main(String[] args) {

//        Predicate p = (Object i) -> i.equals(2);
        Predicate p = i -> i.equals(2);

        Stream.of(1,2,3).filter(p).forEach(System.out::println);

        double x = (Integer) 5;
//        Double d = 5;

        DoubleBinaryOperator f = Double::compare;
//        Function<Integer,String> f = Integer::toString;

        ToDoubleFunction<Integer> fid = (i) -> i/2;
    }
}
