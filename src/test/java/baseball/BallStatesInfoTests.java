package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class BallStatesInfoTests {

    BallStatesInfo ballStatesInfo;

    @BeforeEach
    void setUp(){
        ballStatesInfo = new BallStatesInfo();
    }

    @Test
    @DisplayName("구종에 따라 카운트하고 명세 출력")
    void test(){
        assertThat(ballStatesInfo.toString()).isEqualTo("Nothing");

        ballStatesInfo.countUp(BallState.BALL);
        ballStatesInfo.countUp(BallState.STRIKE);
        ballStatesInfo.countUp(BallState.STRIKE);
        assertThat(ballStatesInfo.toString()).isEqualTo("1볼 2스트라이크 ");
    }


    @Test
    @DisplayName("삼진아웃")
    void testCheck3Strike(){
        assertThat(ballStatesInfo.check3Strike()).isFalse();

        ballStatesInfo.countUp(BallState.STRIKE);
        ballStatesInfo.countUp(BallState.STRIKE);
        ballStatesInfo.countUp(BallState.STRIKE);
        assertThat(ballStatesInfo.check3Strike()).isTrue();
    }

}
