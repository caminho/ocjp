package java8addons;

import java.util.Arrays;
import java.util.List;

public class ReplaceAllExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 5, 7, 8, 4, 2);

        numbers.replaceAll(n -> n*2);

        System.out.println(numbers);
    }
}
