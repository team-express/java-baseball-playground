package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.MyMathUtil;

import static org.assertj.core.api.Assertions.*;
public class BallMakerTests {
    @Test
    @DisplayName("사용자가 1~9사이의 숫자를 입력하였는지 체크")
    void test(){
        BallMaker ballMaker = new BallMaker();

        assertThat(ballMaker.checkRange(0)).isFalse();
        assertThat(ballMaker.checkRange(10)).isFalse();

        assertThat(ballMaker.checkRange(1)).isTrue();
        assertThat(ballMaker.checkRange(9)).isTrue();
    }

    @Test
    @DisplayName("사용자가 3자리수를 입력하였는지")
    void test2(){

        BallMaker ballMaker = new BallMaker();
        assertThat(ballMaker.checkNum(11)).isFalse();
        assertThat(ballMaker.checkNum(111)).isTrue();
        assertThat(ballMaker.checkNum(1111)).isFalse();

    }

}
