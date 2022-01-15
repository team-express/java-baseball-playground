package baseball;


import java.util.List;

public class GameUtil {

    public void runGame() {

        if (runOnlyOnceGame()) {
            showMenu();
        }
    }

    public boolean runOnlyOnceGame() {

        Computer computer = new Computer();
        List<Integer> computers = computer.makeNumbers();

        return gameResult(computers);
    }

    private boolean gameResult(List<Integer> computers) {
        boolean threeStrike = true;
        while (threeStrike) {

            Player player = new Player();
            List<Integer> playerNumbers = player.makeNumbers();
            Referee referee = new Referee();

            String result = referee.informStrikeBall(computers, playerNumbers);
            System.out.println(result);
            threeStrike = isGame(threeStrike, result);
        }

        return true;
    }

    private boolean isGame(boolean game, String result) {
        if (result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            game = false;
        }
        return game;
    }

    private void showMenu() {
        ScannerUtil scannerUtil = new ScannerUtil();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int choice = scannerUtil.insertInt();
        if (choice == 1) {
            runGame();
        }

        while (choice != 1 && choice != 2) {
            System.out.println("잘못 입력하셨습니다. 다시입력해주세요.");
            choice = scannerUtil.insertInt();
        }
        System.out.println("수고하셨습니다.");
    }
}
