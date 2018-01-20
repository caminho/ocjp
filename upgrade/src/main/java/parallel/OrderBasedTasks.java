package parallel;

import java.util.Arrays;

public class OrderBasedTasks {

    public static void main(String[] args) {

        // serial
        Integer anyNumberFromStream =
                Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get();
        System.out.println(anyNumberFromStream);

        // parallel
        Integer anyNumberFromParallelStream =
                Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get();
        System.out.println(anyNumberFromParallelStream);
    }
}
