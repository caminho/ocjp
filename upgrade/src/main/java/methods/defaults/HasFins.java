package methods.defaults;

public interface HasFins {
    default public int getNumberOfFins() {
        return 4;
    }

    default double getLongestFinLength() {
        return 20.0;
    }

    public default boolean doFinsHaveScales() {
        return true;
    }

    String name();
}

interface SharkFamily extends HasFins {

    default String name() {
        return "defaultName";
    }

    public default int getNumberOfFins() {
        return 8;
    }

    public double getLongestFinLength();
    // DOES NOT COMPILE
    //public boolean doFinsHaveScales() {
    //    return false;
    //}
}
