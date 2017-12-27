package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExamples {

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {

        print("Constructing durations with static factories");
        Duration daily = Duration.ofDays(1);
        print(daily);
        Duration hourly = Duration.ofHours(1);
        print(hourly);
        Duration everyMinute = Duration.ofMinutes(1);
        print(everyMinute);
        Duration everyTenSecond = Duration.ofSeconds(10);
        print(everyTenSecond);
        Duration everyMilli = Duration.ofMillis(1);
        print(everyMilli);
        Duration everyNano = Duration.ofNanos(1);
        print(everyNano);

        Duration duration = Duration.ofSeconds(3 * 3600 + 15 * 60 + (long)30); // PT3H15M30S
        print(duration);

        print("\nConstructing durations with ChronoUnit");
        daily = Duration.of(1, ChronoUnit.DAYS);
        print(daily);
        hourly = Duration.of(1, ChronoUnit.HOURS);
        print(hourly);
        everyMinute = Duration.of(1, ChronoUnit.MINUTES);
        print(everyMinute);
        everyTenSecond = Duration.of(10, ChronoUnit.SECONDS);
        print(everyTenSecond);
        everyMilli = Duration.of(1, ChronoUnit.MILLIS);
        print(everyMilli);
        everyNano = Duration.of(1, ChronoUnit.NANOS);
        print(everyNano);
        Duration halfDay = Duration.of(1, ChronoUnit.HALF_DAYS); // 12h
        print(halfDay);

        print("\nDuration between temporal values");
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date = LocalDate.of(2016, 1, 20);

        print(ChronoUnit.HOURS.between(one, two)); // obcina minuty (zostawia pelne godziny)
        print(ChronoUnit.HOURS.between(two, one));
        print(ChronoUnit.MINUTES.between(one, two));
        // java.time.DateTimeException: Unable to obtain LocalTime from TemporalAccessor:
        // 2016-01-20 of type java.time.LocalDate
        // print(ChronoUnit.MINUTES.between(one, date));

        print("\nAdding duration");
        date = LocalDate.of(2016, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Duration duration2 = Duration.ofHours(6);
        print(dateTime.plus(duration2));
        print(time.plus(duration2));
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        // print(date.plus(duration2));

        Duration duration3 = Duration.ofHours(23);
        print(dateTime.plus(duration3));
        print(time.plus(duration3));
        // java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        // print(date.plus(duration3));
    }
}
