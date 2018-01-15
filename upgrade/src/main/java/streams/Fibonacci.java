package streams;

import java.util.stream.Stream;

class Pair {
    private int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    static Pair of(int first, int second) {
        return new Pair(first, second);
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

public class Fibonacci {
    public static void main(String[] args) {

        Stream.iterate(Pair.of(0, 1),
                p -> Pair.of(p.getSecond(), p.getFirst() + p.getSecond()))
                .limit(10)
                .map(Pair::getSecond)
                .forEach(System.out::println);
    }
}
