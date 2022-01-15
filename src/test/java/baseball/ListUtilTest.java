package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListUtilTest {

    @Test
    @DisplayName("리스트의 사이즈가 3이면 true 반환")
    void checkListSize() throws Exception {
        //given
        ListUtil listUtil = new ListUtil();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //when
        boolean checkListSize = listUtil.checkListSize(list);

        //then
        assertThat(checkListSize).isTrue();
    }

    @Test
    @DisplayName("리스트에 중복 숫자가 들어갈 경우 리스트에 add 안함")
    void checkDuplicate() throws Exception {
        //given
        ListUtil listUtil = new ListUtil();

        int number = 1;
        List<Integer> list = new ArrayList<>();

        //when
        for (int i = 0; i < 2; i++) {
            listUtil.distinctNumberAdd(list, number);
        }
        //then
        assertThat(list.size()).isEqualTo(1);
    }
}
