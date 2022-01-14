import java.util.List;
import java.util.Scanner;

public class Play {

    public void playGame() {

        ReadyGame readyGame = new ReadyGame();
        Compare compare = new Compare();
        boolean gameState = true;


        // 1. 게임 준비
        System.out.println("숫자 야구를 시작합니다.");
        List<Integer> computerNumber = readyGame.creatRandomNumber();


        while (gameState) {
            System.out.println("숫자를 입력하세요.\n>");
            List<Integer> userNumber = readyGame.splitNumber(readyGame.inputUserNumber());

            // 사용자의 입력 숫자가 잘못된 경우 재입력 받는다.
            retryUserNumber(userNumber);

            // 2. 게임 진행
            int sameNumberCount = compare.checkSameNumber(userNumber, computerNumber);
            int sameLocationNumberCount = compare.checkSameLocation(userNumber, computerNumber);

            // 게임의 결과를 확인한다
            String gameResult = compare.refereeGame(sameNumberCount, sameLocationNumberCount);
            System.out.println(gameResult);

            // 숫자를 모두 맞혔을 경우, 사용자의 입력을 반복하는 while 값을 false로 변경한다.
            gameState = stopGameLoop(sameNumberCount, sameLocationNumberCount);

            // 숫자를 모두 맞혔을 경우, 게임 재개 여부를 확인한다.
            if (askRegame(sameNumberCount, sameLocationNumberCount) == 1) {
                playGame();
            }
        }
    }

    private List<Integer> retryUserNumber(List<Integer> userNumber) {

        ReadyGame readyGame = new ReadyGame();
        List<Integer> retryUserNumber = userNumber;

        while (!(readyGame.validateNumber(retryUserNumber))) {
            System.out.println("잘못된 숫자입니다. 숫자를 다시 입력하세요.\n>");
            List<Integer> tempUserNumber = readyGame.splitNumber(readyGame.inputUserNumber());
            retryUserNumber = tempUserNumber;
        }
        return retryUserNumber;

    }

    private int askRegame(int sameNumberCount, int sameLocationNumberCount) {

        int userChoose = 2;

        if (sameNumberCount == 3 && sameLocationNumberCount == 3) {
            System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 아무 숫자나 입력해주세요.");
            Scanner scanner = new Scanner(System.in);
            userChoose = scanner.nextInt();

        }
        return userChoose;
    }

    private boolean stopGameLoop(int sameNumberCount, int sameLocationNumberCount) {
        boolean gameState = true;
        if (sameNumberCount == 3 && sameLocationNumberCount == 3) {
            return false;
        }
        return gameState;
    }


    public static void main(String[] args) {
        Play play = new Play();
        play.playGame();

    }
}
