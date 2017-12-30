package lambdas;

import java.util.function.Consumer;

@FunctionalInterface
interface Sprint {
    public void sprint(Animal animal);
}

interface Run extends Sprint {}

interface SprintFaster extends Sprint {
    @Override
    void sprint(Animal animal);
}

interface Skip extends Sprint {
    public default int getHopCount(Kangaroo kangaroo) {return 10;}
    public static void skip(int speed) {}
}

@FunctionalInterface
interface WeirdLambda {
    void doSth();
}

public class Tiger implements Sprint {

    @Override
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! " + animal.toString());
    }

    static void testSprint(Sprint sprint) {}

    static void testRun(Run sprint) {}

    static void testSprintFaster(SprintFaster sprint) {}

    static void testSkip(Skip skip){}

    static void testWeirdLambda(WeirdLambda lambda){}

    public static void main(String[] args) {
        testSprint(animal -> {});
        testRun(animal -> {});
        testSprintFaster(animal -> {});
        testSkip(animal -> {});
        testWeirdLambda(() -> {});

        ((WeirdLambda) (()->{
            System.out.println("hello");
        })).doSth();

        ((Consumer<String>)(s ->
                System.out.println(s)))
                .accept("hello world");
    }
}
