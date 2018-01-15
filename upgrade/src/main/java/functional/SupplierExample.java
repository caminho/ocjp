package functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        // statyczna metoda fabrykujaca
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        Supplier<LocalDate> s2 = LocalDate::now;

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        // konstruktor
        Supplier<StringBuilder> s3 = () -> new StringBuilder();
        Supplier<StringBuilder> s4 = StringBuilder::new;

        System.out.println(s3.get().append("hello"));
        System.out.println(s4.get().append("world"));

        Supplier<ArrayList<String>> s5 = ArrayList<String>::new;
        Supplier<List<String>> s6 = () -> new ArrayList<>();

        System.out.println(s5.get());
        System.out.println(s6);
    }
}
