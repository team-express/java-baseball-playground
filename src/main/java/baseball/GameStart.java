package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStart {

    public void game() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> computer = baseballNumbers.makeNumbers();

        Game game = new Game();
        while (true) {
            List<Integer> player = playerNumbers();
            System.out.println(computer);
           String result = game.getResult(computer, player);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("정답입니다.");
                break;
            }
            System.out.println("틀렸습니다.");
        }
    }

    public List<Integer> playerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> player = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Util util = new Util();

        while (util.listSizeUnderThree(player)) {
            int number = scanner.nextInt();

            boolean check = util.checkDuplicate(player, number);
            if (!check) {
                System.out.println("중복된 숫자가 있습니다. 다시 입력해주세요.");
            }
            if (check) {
                util.addNumber(player, number);
            }
        }

        return player;
    }

}
