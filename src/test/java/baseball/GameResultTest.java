package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("3스트라이크 확인")
    void check3Strike() throws Exception {

        //given
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(Arrays.asList(1, 2, 4), Arrays.asList(1, 2, 4));
        //then

        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("낫싱")
    void checkNothing() throws Exception {

        //given
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

        //then
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼만 있는경우")
    void onlyBall() throws Exception {

        //given
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2));

        //then
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    @DisplayName("스트라이크만 있는 경우")
    void onlyStrike() throws Exception {

        //given
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4));

        //then
        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("스트라이크와 볼 섞여 있는 경우")
    void ballStrike() throws Exception {

        //given
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));

        //then
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}
