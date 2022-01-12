package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void 같은수_다른자리_갯수_확인() throws Exception {

        //given
        Game game = new Game();

        //when
//        int result = game.getBall(Arrays.asList(1, 2, 4));
        //then

//        assertThat(result).isEqualTo(0);
    }

    @Test
    void 같은수_같은자리_갯수_확인() throws Exception {
        //given
        Game game = new Game();
        //when
        int result = game.getStrike(Arrays.asList(1, 2, 4));
        //then

        assertThat(result).isEqualTo(3);
    }
}
