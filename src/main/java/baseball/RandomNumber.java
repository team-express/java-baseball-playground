package baseball;

import java.util.Random;

public class RandomNumber {

    public int make() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}
