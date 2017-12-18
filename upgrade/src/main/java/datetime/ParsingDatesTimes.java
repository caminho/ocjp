package datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ParsingDatesTimes {

    public static void main(String[] args) {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("01 02 2015", f);
        LocalTime time = LocalTime.parse("11:22"); // ISO_LOCAL_TIME
        System.out.println(date);
        System.out.println(time);
    }
}
