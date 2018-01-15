package lambdas;

public interface Gorilla {
    String move();
}

class GorillaFamily {

    String walk = "walk";

    void everyOnePlay(boolean baby) {
        String approach = "amble";
//        approach="run";
        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorilla gorilla) {
        System.out.printf(gorilla.move());
    }
}
