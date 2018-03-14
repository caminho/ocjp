package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DaylightSavings {

    public static void main(String[] args) {
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
        System.out.println(ld1);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));  // 2:0 gmt-5 -> 7:00 UTC
        System.out.println(zd1);
        LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);// 1:00 gmt-4 -> 5:00 UTC
        System.out.println(ld2);
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        System.out.println(zd2);
        System.out.println(zd2.plusHours(1));

        System.out.println();
        long x = ChronoUnit.HOURS.between(zd1, zd2); System.out.println(x);
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
