package baseball;

import java.util.List;

public class GameResult {

    public String getResult(List<Integer> computer, List<Integer> player) {

        int ball = 0;
        int strike = getStrike(computer, player);

        for (Integer integer : computer) {
            ball = checkBall(player, ball, integer);
        }

        int i = ball - strike;

        if (i == 0 && strike != 0) {
            return strike + "스트라이크";
        }

        if (strike == 0 && i != 0) {
            return i + "볼";
        }

        if (i == 0) {
            return "낫싱";
        }

        return i + "볼 " + strike + "스트라이크";
    }

    private int getStrike(List<Integer> computer, List<Integer> player) {

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
