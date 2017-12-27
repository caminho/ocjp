package datetime;

import java.time.*;

public class PeriodExamples {
    public static void main(String[] args) {

        System.out.println("\nPeriod examples");
        Period annualy = Period.ofYears(2);
        System.out.println(annualy);
        Period monthly = Period.ofMonths(34);
        System.out.println(monthly);
        Period daily = Period.ofDays(40);
        System.out.println(daily);
        Period weekly = Period.ofWeeks(3);
        System.out.println(weekly);

        Period period2 = Period.of(0, 4, 5);
        System.out.println(period2);

        System.out.println("\nAdding periods");
        LocalDate date = LocalDate.of(2015, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(12, 34, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        Period period = Period.ofMonths(1);
        System.out.println(date.plus(period));
        System.out.println(dateTime.plus(period));
        //java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Months
        //System.out.println(time.plus(period));
    }
}
