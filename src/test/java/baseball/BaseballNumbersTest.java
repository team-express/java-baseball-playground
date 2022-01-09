package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    @Test
    void 리스트사이즈가_3보다_작을경우_True() throws Exception {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //when
        boolean checkListSize = baseballNumbers.listSizeUnderThree(list);
        //then
        assertThat(checkListSize).isTrue();
    }

    @Test
    void 리스트에_중복된_숫자가_없을경우_숫자추가() throws Exception {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> numbers = new ArrayList<>();
        int number = 1;
        //when
        baseballNumbers.addNumber(numbers, number);
        baseballNumbers.addNumber(numbers, number);
        baseballNumbers.addNumber(numbers, number);
        //then
        assertThat(numbers.size()).isEqualTo(1);
    }

    @Test
    void NumbersListSize() throws Exception {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        //when

        //then
        List<Integer> numbers = baseballNumbers.makeNumbers();

        System.out.println("numbers = " + numbers);
        assertThat(numbers.size()).isEqualTo(3);
    }
}