package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class SwitchingToys {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2015, Month.MARCH, 30);

        Period period = Period.ofMonths(1);
        performAnimalEnrichment(startDate, endDate, period);
    }

    private static void performAnimalEnrichment(LocalDate startDate, LocalDate endDate, Period period) {
        LocalDate upTo = startDate;
        while (upTo.isBefore(endDate)) {
            System.out.println("Give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
    }
}
