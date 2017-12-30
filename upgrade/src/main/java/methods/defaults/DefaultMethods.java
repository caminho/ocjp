package methods.defaults;

interface IsWarmBlooded {
    boolean hasScales();

    public default double getTemperature() {
        return 10.0;
    }
}

interface Carnivore {
    // DOES NOT COMPILE public int getRequiredFoodAmount() {
    //    public default void eatMeat();
    // DOES NOT COMPILE
    //    return 13;
}

interface A {
    void doStuff();
}

interface B extends A {
    @Override
    default void doStuff() {
        System.out.println("doStuff");
    }
}

public class DefaultMethods {

    public static void main(String[] args) {
        // ERROR: potrzebna instancja
    //        IsWarmBlooded.getTemperature();
    }
}
