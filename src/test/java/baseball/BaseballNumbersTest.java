package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumbersTest {

    @Test
    @DisplayName("랜덤넘버가 담긴 리스트의 사이즈 확인")
    void NumbersListSize() throws Exception {
        //given
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        //when
        List<Integer> numbers = baseballNumbers.makeNumbers();
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }
}