package parallel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/*
 serial:   Task completed in 45,9820 s
 parallel: Task completed in 11,5250 s
 */

public class WhaleDateCalculator {

    public int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // do nothing here
        }
        return input + 1;
    }

    public void processAllData(List<Integer> data) {
        // data.stream()
        data.parallelStream()
                .map(input -> processRecord(input))
                .count();
    }

    public static void main(String[] args) {

        WhaleDateCalculator calculator = new WhaleDateCalculator();

        // prepare input
        List<Integer> data = IntStream.range(0, 4000).boxed().collect(toList());

        // process data
        long start = System.currentTimeMillis();
        calculator.processAllData(data);
        long end = System.currentTimeMillis() - start;

        // report
        System.out.printf("\nTask completed in %g s", end / 1000.0);
    }
}
