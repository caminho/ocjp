package primitives;

import java.util.function.BooleanSupplier;

public class PrimitiveInterfaces {

    public static void main(String[] args) {

        // boolean
        BooleanSupplier b1 = () -> true;
        BooleanSupplier b2 = () -> Math.random() > .5;

        System.out.println(b1.getAsBoolean());
        System.out.println(b2.getAsBoolean());
    }
}
