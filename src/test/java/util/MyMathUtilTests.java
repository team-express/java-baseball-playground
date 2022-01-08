package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MyMathUtilTests {
    @ParameterizedTest
    @CsvSource(value = {"11:false","111:true","1111:false"},delimiter = ':')
    @DisplayName("파라미터로 전달된 값이, 파라미터로 전달된 자릿수 인지 판단")
    void test5(int input,boolean output){
        assertThat(MyMathUtil.checkDigit(input,3)).isEqualTo(output);
    }
}
