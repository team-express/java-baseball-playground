package baseball;

import java.util.List;
import java.util.Scanner;

public class GameStart {
    public void game() {

        boolean gameChoice = true;
        while (gameChoice) {
            firstGame();
            gameChoice = isGameResult();
        }
    }

    public void firstGame() {
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

    private boolean isGameResult() {
        boolean playerChoice = true;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int restart = scanner.nextInt();

        if (restart == 2) {
            playerChoice = false;
            return playerChoice;
        }
        return playerChoice;
    }
}

