package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerBalls {

    public List<Integer> playerNumbers() {

        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> player = new ArrayList<>();

        insertPlayerNumber(player);

        return player;
    }

    private void insertPlayerNumber(List<Integer> player) {

        Util util = new Util();

        while (util.listSizeUnderThree(player)) {
            checkPlayerNumber(player, util);
        }
    }

    private void checkPlayerNumber(List<Integer> player, Util util) {

        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.next();

        String[] numbers = numberStr.split("");

        for (String str : numbers) {

            int number = Integer.parseInt(str);

            boolean check = util.checkDuplicate(player, number);

            if (!check) {
                player.clear();
                System.out.println("중복된 숫자가 있습니다. 다시 입력해주세요.");
                System.out.print("숫자를 입력해주세요: ");
                break;
            }

            if (player.size() > 3) {
                player.clear();
                System.out.println("세자리가 넘었습니다. 다시 입력해주세요.");
                System.out.print("숫자를 입력해주세요: ");
                break;
            }

            util.addNumber(player, number);

        }
    }
}
