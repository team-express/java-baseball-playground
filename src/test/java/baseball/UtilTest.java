package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UtilTest {

    @Test
    void 리스트사이즈가_3보다_작을경우_True() throws Exception {
        //given
        Util util = new Util();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //when
        boolean checkListSize = util.listSizeUnderThree(list);
        //then
        assertThat(checkListSize).isTrue();
    }

    @Test
    void 리스트_중복확인() throws Exception {
        //given
        Util util = new Util();

        //when
        boolean checkDuplicate = util.checkDuplicate(Arrays.asList(1, 2), 1);

        //then

        assertThat(checkDuplicate).isFalse();
    }

    @Test
    void 리스트에_중복된_숫자가_없을경우_숫자추가() throws Exception {
        //given
        Util util = new Util();

        List<Integer> numbers = new ArrayList<>();
        int number = 1;
        //when
        util.addNumber(numbers, number);
        util.addNumber(numbers, number);
        util.addNumber(numbers, number);
        //then
        assertThat(numbers.size()).isEqualTo(1);
    }


}