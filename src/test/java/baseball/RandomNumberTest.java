package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤 넘버 만들기 테스트 -> 숫자 범위가 1~9 사이")
    void randomNumberMakeTest() throws Exception {
        //given
        RandomNumber number = new RandomNumber();

        //when
        int randomNUmber = number.make();

        //then
        assertThat(randomNUmber).isBetween(1, 9);
    }
}
