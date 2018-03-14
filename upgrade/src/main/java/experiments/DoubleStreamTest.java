package experiments;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.*;

public class DoubleStreamTest {

    public static void main(String[] args) {

        ToDoubleBiFunction<Integer, Integer> tdbf1 = (f1,f2) -> f1+f2;

        // BiFunction<Integer, Integer, Double> bf =  (f1, f2) -> f1+f2;

        ToDoubleFunction<Integer> td = f -> f;
//        Function<Integer, Double> td2 = f -> f;

        Stream<String> sss = DoubleStream.of(12.1, 12.3).boxed()
                .map((Double d) -> d.toString());


        int z1 = 2;
        Integer z2 = 45;
        double d1 = z1;
//        Double d2 = z1;

//        long l1 = d;
//        Long l2 = z1;

        Double in = 2.0;
        Double d3 = in * 2;

        class Book {
            String title;
            Double price;

            public Book(String title, Double price) {
                this.title = title;
                this.price = price;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }
        }

        List<List<Book>> books = Arrays.asList(
                Arrays.asList(
                        new Book("book1", 7.0),
                        new Book("book2", 9.0)
                ),
                Arrays.asList(
                        new Book("book3", 5.0),
                        new Book("book4", 5.0)
                )
        );
        double d = books.stream()
                .flatMap(List::stream)
                .mapToDouble(Book::getPrice)
                .sum();
        System.out.println(d);

        d = books.stream()
                .flatMap(List::stream)
                .collect(Collectors.summingDouble(Book::getPrice));
        System.out.println(d);

        d = books.stream()
                .flatMap(List::stream)
                .collect(Collectors.summarizingDouble(Book::getPrice))
                .getSum();
        System.out.println(d);

    }
}
