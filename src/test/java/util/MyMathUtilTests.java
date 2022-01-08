package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyMathUtilTests {

    @Test
    @DisplayName("n자리 이하 수라면 10^n로 나누면 몫이 0이야")
    void test3(){
        assertThat(MyMathUtil.checkDigitUpper(0,3)).isTrue();
        assertThat(MyMathUtil.checkDigitUpper(1,3)).isTrue();
        assertThat(MyMathUtil.checkDigitUpper(111,3)).isTrue();

        assertThat(MyMathUtil.checkDigitUpper(1111,3)).isFalse();
    }

    @Test
    @DisplayName("n자리 이상 수라면 10^(n-1)로 나누면 몫이 0이 아니야")
    void test4(){
        assertThat(MyMathUtil.checkDigitLower(11,3)).isFalse();

        assertThat(MyMathUtil.checkDigitLower(111,3)).isTrue();
        assertThat(MyMathUtil.checkDigitLower(1111,3)).isTrue();
    }

    @Test
    @DisplayName("위 두개를 합침")
    void test5(){
        assertThat(MyMathUtil.checkDigit(11,3)).isFalse();
        assertThat(MyMathUtil.checkDigit(1111,3)).isFalse();

        assertThat(MyMathUtil.checkDigit(111,3)).isTrue();
    }
}
