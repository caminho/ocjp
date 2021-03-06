package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class ManipulatingDatesTimes {

    public static void main(String[] args) {

        System.out.println("Manipulating dates");

        LocalDate date = LocalDate.of(2018, Month.JANUARY, 20);
        System.out.println(date);

        date = date.plusDays(2);
        System.out.println(date);

        date = date.plusWeeks(1);
        System.out.println(date);

        date = date.plusMonths(1);
        System.out.println(date);

        date = date.plusYears(5);
        System.out.println(date);

        System.out.println("\nManipulating times");

        LocalDateTime dateTime = LocalDateTime.of(
                LocalDate.of(2020, Month.JANUARY, 20),
                LocalTime.of(5, 15));
        System.out.println(dateTime);

        dateTime = dateTime.minusDays(1);
        System.out.println(dateTime);

        dateTime = dateTime.minusHours(10);
        System.out.println(dateTime);

        dateTime = dateTime.minusSeconds(30);
        System.out.println(dateTime);

        System.out.println("\nChaining calls");
        System.out.println(LocalDateTime.of(2020, Month.JANUARY, 20, 5, 15)
                .minusDays(1).minusHours(10).minusSeconds(30));
    }
}
