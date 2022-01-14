import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareTest {

    Compare compare = new Compare();

    @Test
    void 동일한_숫자_갯수_확인() throws Exception {
        // given
        // 숫자 list 2개가 주어진다
        List<Integer> userNumberList = Arrays.asList(1, 3, 5);
        List<Integer> computerNumberList = Arrays.asList(5, 2, 3);

        // when
        // 일치하는 숫자를 확인해주는 메서드를 실행한다
        int sameNumberAmount = compare.checkSameNumber(userNumberList, computerNumberList);

        // then
        // 일치하는 숫자를 확인한다.
        assertThat(sameNumberAmount).isEqualTo(2);
    }

    @Test
    void 동일한_숫자의위치_갯수_확인() throws Exception {

        // given
        // 3개의 숫자로 구성된 List 객체 2개가 주어진다.
        List<Integer> userNumberList = Arrays.asList(1, 2, 5);
        List<Integer> computerNumberList = Arrays.asList(1, 5, 2);

        // when
        // 두 List를 비교하여 동일한 위치에 동일한 수를 가진 숫자가 몇 개인지 확인하는 메서드를 실행한다
        int sameLocationNumberAmount = compare.checkSameLocation(userNumberList, computerNumberList);

        // then
        // 일치하는 숫자가 정확한지 확인한다.
        assertThat(sameLocationNumberAmount).isEqualTo(2);
    }

    @Test
    void 게임_결과_확인() throws Exception {

        // given
        // '동일한 숫자의 갯수'와 '위치가 동일한 숫자의 갯수'가 주어진다.

        int sameNumberAmount = 3;
        int sameLocationNumberAmount = 1;

        // when
        // 볼과 스트라이크로 환산하는 메서드를 통해 결과를 받는다.
        String gameResult = compare.refereeGame(sameNumberAmount, sameLocationNumberAmount);

        // then
        // 게임 결과가 정확한지 확인한다.
        assertThat(gameResult).isEqualTo("1 스트라이크 2 볼");
        //assertThat(gameResult).isEqualTo("낫싱");
    }


}