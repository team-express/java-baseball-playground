import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReadyGameTest {

    ReadyGame readyGame = new ReadyGame();

    @Test
    void inputUserNumberTest() {

        String userNumber = "123";// Sacanner를 통해 사용자가 3자리 수를 입력했다고 가정
        assertThat(userNumber.length()).isEqualTo(3);

    }

    @Test
    void creatRandomNumberTest() {

        List<Integer> computerNumber = readyGame.creatRandomNumber();
        SoftAssertions softly = new SoftAssertions();

        assertThat(computerNumber.size()).isEqualTo(3); // 3자리 숫자 확인

        for (Integer number : computerNumber) {
            assertThat(number > 0 && number < 10).isEqualTo(true); // 각 숫자의 범위가 1~10에 해당하는지 확인
            assertThat(Collections.frequency(computerNumber, number)).isEqualTo(1); // 해당 값이 1개만 존재
        }
    }

    @Test
    void splitNumberTest() {
        String userNumber = "456";
        List<Integer> userNumberList = readyGame.splitNumber(userNumber);

        assertThat(userNumberList.toString()).isEqualTo("[4, 5, 6]");

    }


    @Test
    void validateNumberTest() {
        List<Integer> userNumberList = Arrays.asList(1, 2, 3);
        boolean validateResult = readyGame.validateNumber(userNumberList);

        assertThat(validateResult).isEqualTo(true); // 테스트 1: 프로덕트 코드에 기대하는 결과가 true인지 확인

        assertThat(userNumberList.size()).isEqualTo(3); // 테스트 2: 3자리 숫자 확인

        for (Integer number : userNumberList) {
            assertThat(number > 0 && number < 10).isEqualTo(true); // 각 숫자의 범위가 1~10에 해당하는지 확인
            assertThat(Collections.frequency(userNumberList, number)).isEqualTo(1); // 해당 값이 1개만 존재
        }
    }




}