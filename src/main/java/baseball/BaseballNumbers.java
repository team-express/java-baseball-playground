package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    public List<Integer> makeNumbers() {

        MakeRandomNumber makeRandomNumber = new MakeRandomNumber();

        boolean result = true;

        List<Integer> numbers = new ArrayList<>();

        while (result) {
            int number = makeRandomNumber.make();
            numbers = addNumber(numbers, number);
            result = listSizeUnderThree(numbers);
        }

        return numbers;
    }

    public boolean listSizeUnderThree(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    public List<Integer> addNumber(List<Integer> numbers, int number) {
        checkDuplicate(numbers, number);
        return numbers;
    }

    private void checkDuplicate(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
