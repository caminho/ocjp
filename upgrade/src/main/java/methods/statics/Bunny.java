package methods.statics;

public class Bunny implements Hop {
    public void printDetails() {

        // DOES NOT COMPILE
        // System.out.println(getJumpHeight());

        System.out.println(Hop.getJumpHeight()); // OK

        System.out.println(Move.move());
        // DOES NOT COMPILE
        //System.out.println(Hop.move());
    }
}
