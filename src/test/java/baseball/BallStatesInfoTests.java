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
    @DisplayName("명세 반환")
    void testToString(){
        assertThat(ballStatesInfo.toString()).isEqualTo("Nothing");

        ballStatesInfo.plusBallCount();
        ballStatesInfo.plusStrikeCount();
        ballStatesInfo.plusStrikeCount();
        assertThat(ballStatesInfo.toString()).isEqualTo("1볼 2스트라이크 ");
    }

    @Test
    @DisplayName("삼진아웃")
    void testCheck3Strike(){
        assertThat(ballStatesInfo.check3Strike()).isFalse();

        ballStatesInfo.plusStrikeCount();
        ballStatesInfo.plusStrikeCount();
        ballStatesInfo.plusStrikeCount();
        assertThat(ballStatesInfo.check3Strike()).isTrue();
    }

}
