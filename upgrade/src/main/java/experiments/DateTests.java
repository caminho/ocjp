package experiments;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTests {

    public static void main(String[] args) {

        Year year1 = Year.of(2018);
        System.out.println(year1);
        Year y1 = Year.of(2017);
        Year y2 = Year.of(2018);
        System.out.println(ChronoUnit.NANOS.between(
                y1.atDay(1).atStartOfDay(),
                y2.atDay(1).atStartOfDay()
        ));

        LocalTime lt1 = LocalTime.of(12, 11);
        LocalTime lt2 = LocalTime.of(12, 11, 0);
        LocalTime lt3 = LocalTime.of(12, 11, 0, 0);

        System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(lt3.format(DateTimeFormatter.ISO_LOCAL_TIME));

        Year y3 = Year.of(2017);
        YearMonth ym1 = YearMonth.of(2014, 5);

        MonthDay md = MonthDay.of(5, 18);
        LocalDate localDate = y3.atMonthDay(md);
        System.out.println(ym1);
    }
}
