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
    @DisplayName("주어진 수를 어떤수로 나누었을 때 몫이 있는가")
    void testHasShare(){
        assertThat(MyMathUtil.hasShare(111,1000)).isFalse();
        assertThat(MyMathUtil.hasShare(111,100)).isTrue();
    }

    @Test
    @DisplayName("주어진 수가 몇자리 수인지 구하여라")
    void testGetDigit(){
        assertThat(MyMathUtil.getDigit(0)).isEqualTo(0);
        assertThat(MyMathUtil.getDigit(1)).isEqualTo(1);
        assertThat(MyMathUtil.getDigit(123)).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 수의 n번째 자리수를 구하여라")
    void testGetDigitValue(){
        assertThat(MyMathUtil.getDigitValue(123,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자가 입력한 3숫자를 각각으로 나눈다")
    void testDivide(){
        List<Integer> dividedNums=MyMathUtil.divide(123,3);
        //string[]이 아닌지 containsExactly를 사용할 수 없네..
        //String.charAt + parse버전으로 바꾸어야하나..
        //람다스트림이 답이될 수 있을까
        assertThat(dividedNums.contains(1)).isTrue();
        assertThat(dividedNums.contains(2)).isTrue();
        assertThat(dividedNums.contains(3)).isTrue();
    }
}
