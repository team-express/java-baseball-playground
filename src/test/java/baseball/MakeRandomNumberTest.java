package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeRandomNumberTest {

    @Test
    void 한자리_랜덤숫자_생성() {

        MakeRandomNumber makeRandomNumber = new MakeRandomNumber();
        int number = makeRandomNumber.make();
        assertThat(number).isBetween(1, 9);
    }

}
