package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTests {
    @Test
    @DisplayName("생성 및 getter 테스트")
    void testBall(){
        Ball ball = new Ball(1);
        assertThat(ball.getNum()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:2:false"},delimiter = ':')
    @DisplayName("두 볼 equals테스트")
    void testEquals(int input1,int input2,boolean output){
        assertThat(new Ball(input1).equals(new Ball(input2))).isEqualTo(output);
    }

    @Test
    @DisplayName("두 볼 equals 테스트2")
    void testEquals2(){
        Ball ball1 = new Ball(1);
        Ball ball2 = new Ball(1);

        assertThat(ball1.equals(ball2)).isTrue();

        ball1.setPosition(2);

        assertThat(ball1.equals(ball2)).isFalse();
    }

}
