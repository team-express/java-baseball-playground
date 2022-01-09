package baseball;

import java.util.List;

public class Game {

    public int getBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        int strike = getStrike(computer,player);

        for (Integer integer : computer) {
            ball = checkBall(player, ball, integer);
        }
        return ball - strike;
    }

    public int getStrike(List<Integer> computer, List<Integer> player) {

        int strike = 0;

        for (int index = 0; index < 3; index++) {
            strike = checkStrike(computer, player, strike, index);
        }
        return strike;
    }

    private int checkStrike(List<Integer> computer, List<Integer> player, int strike, int index) {
        if (computer.get(index).equals(player.get(index))) {
            strike++;
        }
        return strike;
    }

    private int checkBall(List<Integer> player, int result, Integer integer) {
        if (player.contains(integer)) {
            result++;
        }
        return result;
    }


}
