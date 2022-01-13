package baseball;

import java.util.List;

public class Util {

    public boolean listSizeUnderThree(List<Integer> numbers) {
        return numbers.size() != 3;
    }

    public List<Integer> addNumber(List<Integer> numbers, int number) {
        checkDuplicate(numbers, number);
        return numbers;
    }

    public boolean checkDuplicate(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
            return true;
        }
        return false;
    }
}
