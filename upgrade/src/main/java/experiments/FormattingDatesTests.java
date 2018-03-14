package experiments;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDatesTests {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.of(2014, 1, 1, 21, 10, 33);


        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        System.out.println(
                Duration.between(
                        LocalTime.of(21, 10),
                        LocalTime.of(12, 12)
                ).toHours()
        );
    }
}
