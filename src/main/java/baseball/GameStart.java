package baseball;

import java.util.List;

public class GameStart {

    public void game() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> computer = baseballNumbers.makeNumbers();

        PlayerBalls playerBalls = new PlayerBalls();
        GameResult gameResult = new GameResult();

        boolean result3Strike = true;

        while (result3Strike) {
            List<Integer> player = playerBalls.playerNumbers();

            System.out.println(computer);

            String result = gameResult.getResult(computer, player);
            System.out.println(result);

            result3Strike = isResult3Strike(result);

            System.out.println("틀렸습니다.");
        }
    }

    private boolean isResult3Strike(String result) {

        boolean gameResult = true;

        if (result.equals("3스트라이크")) {
            System.out.println("정답입니다.");
            gameResult = false;
        }
        return gameResult;
    }





}
