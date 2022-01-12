package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    public List<Integer> makeNumbers() {

        MakeRandomNumber makeRandomNumber = new MakeRandomNumber();
        Util util = new Util();

        boolean result = true;

        List<Integer> numbers = new ArrayList<>();

        while (result) {
            int number = makeRandomNumber.make();
            numbers = util.addNumber(numbers, number);
            result = util.listSizeUnderThree(numbers);
        }

        return numbers;
    }

}
