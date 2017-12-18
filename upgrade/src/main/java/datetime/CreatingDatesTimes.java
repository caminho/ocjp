package datetime;

import java.time.*;

public class CreatingDatesTimes {

    public static void main(String[] args) {
        System.out.println("Current date:");
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        System.out.println("\nCreating LocalDate:");
        LocalDate date1 = LocalDate.of(2017, 5, 18);
        System.out.println(date1);
        LocalDate date2 = LocalDate.of(2017, Month.MAY, 18);
        System.out.println(date2);

        System.out.println("\nCreating LocalTime:");
        LocalTime time1 = LocalTime.of(15, 30);
        System.out.println(time1);
        LocalTime time2 = LocalTime.of(15, 30, 45);
        System.out.println(time2);
        System.out.println(LocalTime.of(15, 30, 0));
        System.out.println(LocalTime.of(15, 30, 45, 560));
        System.out.println(LocalTime.of(15, 30, 0, 0));
        System.out.println(LocalTime.of(15, 30, 0, 350));

        System.out.println("\nCreating LocalDateTime");
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, Month.MAY, 18, 15, 30);
        System.out.println(localDateTime1);
        System.out.println(LocalDateTime.of(date1, time1));
    }
}
