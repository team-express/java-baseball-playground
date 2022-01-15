package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("두 개의 리스트에서 몇 개의 숫자가 같은지 확인")
    void countBall() throws Exception {

        //given
        Referee referee = new Referee();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 1, 2);

        //when
        int ball = referee.countBall(list1, list2);

        //then
        assertThat(ball).isEqualTo(3);
    }

    @Test
    @DisplayName("두 개의 리스트에서 같은 자리에 같은 숫자가 몇 개 있는지 확인")
    void countStrike() throws Exception {

        //given
        Referee referee = new Referee();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        //when
        int strike = referee.countStrike(list1, list2);

        //then
        assertThat(strike).isEqualTo(3);
    }

    @Test
    @DisplayName("볼, 스트라이크 갯수 알려주기")
    void ballStrikeCount() throws Exception {

        //given
        Referee referee = new Referee();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        //when
        String inform = referee.informStrikeBall(list1, list2);

        //then
        assertThat(inform).isEqualTo("3스트라이크");
    }
}
