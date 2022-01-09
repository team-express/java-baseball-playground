package baseball;

import java.util.Random;

public class MakeRandomNumber {
    public int make() {
        Random random = new Random();
        int number = random.nextInt(9) + 1;
        return number;
    }
}
