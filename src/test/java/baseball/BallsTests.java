package baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;
public class BallsTests {
    Balls balls;

    @BeforeEach
    void testBalls(){
        balls = new Balls(new Ball(1),new Ball(2),new Ball(3));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,true","1,3,false"},delimiter = ',')
    void testGet(int index, int input, boolean output){
        assertThat(balls.get(index).getNum()==input).isEqualTo(output);
    }
}
