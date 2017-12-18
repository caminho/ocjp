package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDatesAndTimes {

    public static void main(String[] args) {

        usingOwnDateTimeFormatter();

    }

    private static void manualFormatting() {
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 20);

        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
    }

    private static void usingPredefinedDateTimeFormatter() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 13);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    private static void usingLocalizedDateTimeFormatter() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 13);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(shortFormat.format(date));
        System.out.println(shortFormat.format(dateTime));
        // UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
        // System.out.println(shortFormat.format(time)); //

        System.out.println(date.format(shortFormat));
        System.out.println(dateTime.format(shortFormat));

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println(shortDateTime.format(dateTime));
        System.out.println(dateTime.format(mediumDateTime));
    }

    private static void usingOwnDateTimeFormatter() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 13);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter ownFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(ownFormat));
    }
}
