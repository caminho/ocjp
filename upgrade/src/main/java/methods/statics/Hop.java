package methods.statics;

public interface Hop extends Move {
    static int getJumpHeight() {
        return 8;
    }
    default void hej() {
        toString();
    }

    public static void main(String[] args) {
        Hop hop = new Hop() {
        };
        System.out.println(hop.toString());
    }
}
