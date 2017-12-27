package datetime;

import java.time.*;

public class ConvertingToLong {

    public static void main(String[] args) {

        long epochDay = LocalDate.now().toEpochDay();
        System.out.println("Number of days since January 1, 1970: " + epochDay);

        long epochSecond = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toEpochSecond();
        System.out.println("Number of seconds since January 1, 1970: "+ epochSecond);

        epochSecond = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+1"));
        System.out.println("Number of seconds since January 1, 1970: "+ epochSecond);
    }
}
