import baseball.BaseballNumbers;
import baseball.Game;
import baseball.GameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballMain {
    public static void main(String[] args) {

        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> computer = baseballNumbers.makeNumbers();
        System.out.println("computer = " + computer);
        Game game = new Game();
        GameResult gameResult = new GameResult();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            List<Integer> player = new ArrayList<>();

            System.out.println("숫자를 입력하세요");

            String result = getResult(baseballNumbers, computer, game, gameResult, scanner, player);
            if (gameEnd(result)) break;
            System.out.println("틀렸습니다.");
        }
    }

    private static boolean gameEnd(String result) {
        if (result.equals("3스트라이크")) {
            return true;
        }
        return false;
    }

    private static String getResult(BaseballNumbers baseballNumbers, List<Integer> computer, Game game, GameResult gameResult, Scanner scanner, List<Integer> player) {
        while (baseballNumbers.listSizeUnderThree(player)) {
            int number = scanner.nextInt();
            baseballNumbers.addNumber(player, number);
        }

        int ball = game.getBall(computer, player);
        int strike = game.getStrike(computer, player);

        String result = gameResult.getResult(ball, strike);
        System.out.println(result);
        return result;
    }
}
