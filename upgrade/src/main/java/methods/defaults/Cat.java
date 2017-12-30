package methods.defaults;

// Error:(3, 8) java: class methods.optional.Cat inherits unrelated defaults for getSpeed()
// from types methods.optional.Walk and methods.optional.Run
public class Cat implements Walk, Run {

    // po dodaniu implementacji, kompilacja przechodzi bez problemu
    public int getSpeed() {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}
