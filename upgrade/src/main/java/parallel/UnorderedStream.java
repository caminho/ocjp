package parallel;

import java.util.Arrays;

public class UnorderedStream {

    public static void main(String[] args) {

        Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream()
                .unordered()
                .parallel()
                .skip(4)
                .forEach(System.out::println);
    }
}
