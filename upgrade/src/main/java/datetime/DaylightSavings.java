package datetime;

import java.time.*;

public class DaylightSavings {
    public static void main(String[] args) {
        czasLetni();
        czasZimowy();
    }

    private static void czasZimowy() {
        LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]
    }

    private static void czasLetni() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
        time = LocalTime.of(2, 30);
        dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime);
    }
}
