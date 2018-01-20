package parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatefulOperations {

    public static void main(String[] args) {

        // List<Integer> data = new ArrayList<>();  // YOU HAVE TO SYNCHRONIZE
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallelStream()
                .map(i -> {
                    data.add(i); // AVOID STATEFUL LAMBDA EXPRESSIONS!
                    return i;
                })
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
        for (Integer a : data) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
