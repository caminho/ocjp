package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class InstantExamples {
    public static void main(String[] args) throws InterruptedException {
        Instant now = Instant.now();
        Thread.sleep(1000);
        Instant later = Instant.now();
        long duration = Duration.between(now, later).toMillis();
        System.out.println(duration);

        System.out.println("\nZonedDateTime -> Instant");
        LocalDate date = LocalDate.of(2017, 1, 20);
        LocalTime time = LocalTime.of(6, 15);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zonedDateTime);
        Instant fromZoned = zonedDateTime.toInstant();
        System.out.println(fromZoned);

        System.out.println("\nInstant ofEpochSeconds");
        Instant ofEpochSecond = Instant.ofEpochSecond(0);
        System.out.println(ofEpochSecond);

        System.out.println("\nDoing math with Instant");
        Instant nowInstant = Instant.now();
        System.out.println("Now: " + nowInstant);
        System.out.println("Next hour: " + nowInstant.plus(1, ChronoUnit.HOURS));
        System.out.println("Next day: " + nowInstant.plus(1, ChronoUnit.DAYS));
        // UnsupportedTemporalTypeException: Unsupported unit: Weeks
        // System.out.println("Next week: " + nowInstant.plus(1, ChronoUnit.WEEKS));
    }
}
