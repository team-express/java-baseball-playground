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
            checkPlayerNumberSize(player);
        }
    }

    private void checkPlayerNumber(List<Integer> player, Util util) {

        Scanner scanner = new Scanner(System.in);
        String numberStr = scanner.next();

        String[] numbers = numberStr.split("");

        for (String str : numbers) {
            int number = Integer.parseInt(str);
            player = util.addNumber(player, number);
        }

    }

    private void checkPlayerNumberSize(List<Integer> player) {

        boolean checkSize = player.size() != 3;
        String message = "잘못된 숫자입니다.";

        if (checkSize) {
            player.clear();
            System.out.println(message);
            System.out.print("숫자를 입력해주세요: ");
        }
    }
}
