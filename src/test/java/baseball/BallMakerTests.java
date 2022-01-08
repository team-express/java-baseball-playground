package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.MyMathUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BallMakerTests {
    BallMaker ballMaker;

    @BeforeEach
    void setUp(){
        ballMaker = new BallMaker(1,9,3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false","1:true","9:true","10:false"},delimiter = ':')
    @DisplayName("사용자가 1~9사이의 숫자를 입력하였는지 체크")
    void test(int input, boolean output){
        assertThat(ballMaker.checkRangeOfOneNum(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"012:false","123:true"},delimiter = ':')
    @DisplayName("사용자가 입력한 3숫자 모두 1~9조건을 만족하는지")
    void test0(int input, boolean output){
        assertThat(ballMaker.checkRange(input)).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"11:false","111:true","1111:false"},delimiter = ':')
    @DisplayName("사용자가 3자리수를 입력하였는지")
    void test2(int input,boolean output){
        assertThat(ballMaker.checkNum(input)).isEqualTo(output);
    }

}
