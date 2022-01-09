package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameResultTest {

    @Test
    void 볼스트라이크() throws Exception {
        //given
        Game game = new Game();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 3);
        int ball = game.getBall(list1, list2);
        int strike = game.getStrike(list1, list2);
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(ball, strike);
        //then

        Assertions.assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    void 볼스트라이크2() throws Exception {
        //given
        Game game = new Game();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(5, 1, 3);
        int ball = game.getBall(list1, list2);
        int strike = game.getStrike(list1, list2);
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(ball, strike);
        //then

        Assertions.assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼스트라이크3() throws Exception {
        //given
        Game game = new Game();
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        int ball = game.getBall(list1, list2);
        int strike = game.getStrike(list1, list2);
        GameResult gameResult = new GameResult();

        //when
        String result = gameResult.getResult(ball, strike);
        //then

        Assertions.assertThat(result).isEqualTo("낫싱");
    }
}
