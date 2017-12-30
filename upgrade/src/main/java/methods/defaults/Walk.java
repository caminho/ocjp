package methods.defaults;

public interface Walk {
    public default int getSpeed() {
        return 5;
    }
}

