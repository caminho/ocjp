package lambdas;

import java.util.ArrayList;
import java.util.List;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies);
        bunnies.removeIf(bunny -> bunny.charAt(0) != 'h');
        System.out.println(bunnies);
    }
}
