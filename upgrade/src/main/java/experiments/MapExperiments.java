package experiments;

import java.util.HashMap;
import java.util.Map;

public class MapExperiments {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Tomek");
        students.put(2, "Andrzej");
        students.put(5, "Szymon");
        students.put(3, null);
        students.put(8, "osiem");

//        students.computeIfAbsent(1, k->"NEW VALUE");
//        students.computeIfAbsent(2, k->null);
//        students.computeIfAbsent(3, k->null);
//        students.computeIfAbsent(4, k->"NEW VALUE");

//        students.computeIfPresent(1, (k, v) -> "NEW" + v);
//        students.computeIfPresent(5, (k, v) -> null);
//        students.computeIfPresent(3, (k, v) -> "NEW" + v);
//        students.computeIfPresent(4, (k, v) -> "NEW" + v);

//        students.merge(1, "TOMEK", (v1, v2) -> v1+"|"+v2);
//        students.merge(2, "ANDRZEJ", (v1, v2) -> null);
//        students.merge(3, "NULL3", (v1, v2) -> "hejhej");
//        students.merge(4, "NULL4", (v1, v2) -> "hejhej");
//        students.merge(8, "NULL8", (v1, v2) -> "hejhej");


        System.out.println(students);

    }
}
