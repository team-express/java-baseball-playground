package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyMathUtilTests {
    @ParameterizedTest
    @CsvSource(value = {"11:false","111:true","1111:false"},delimiter = ':')
    @DisplayName("파라미터로 전달된 값이, 파라미터로 전달된 자릿수 인지 판단")
    void test5(int input,boolean output){
        assertThat(MyMathUtil.checkDigit(input,3)).isEqualTo(output);
    }

    @Test
    @DisplayName("사용자가 입력한 3숫자를 각각으로 나눈다")
    void testDivide(){
        //이 테스트코드..리팩토링할수있을까
        List<Integer> dividedNums=MyMathUtil.divide(123);

        //string[]이 아닌지 containsExactly를 사용할 수 없네..
        //String.charAt + parse버전으로 바꾸어야하나..
        assertThat(dividedNums.contains(1)).isTrue();
        assertThat(dividedNums.contains(2)).isTrue();
        assertThat(dividedNums.contains(3)).isTrue();
    }
}
