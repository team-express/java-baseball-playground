package baseball;

public class GameResult {

    public String getResult(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball != 0 && strike == 0) {
            return ball + "볼";
        }

        if (ball == 0) {
            return strike+ "스트라이크";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
