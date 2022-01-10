package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BallMaker ballMaker = new BallMaker(1,9,3);
        BallMatcher ballMatcher = new BallMatcher();

        int userChoice=1;

        while(userChoice==1){
            System.out.print("숫자를 입력해 주세요 : ");
            Balls userBalls = ballMaker.createUserBalls(scanner.nextInt());
            Balls computerBalls = ballMaker.createComputerBalls();
            BallStatesInfo ballStatesInfo = ballMatcher.getBallStatesInfo(userBalls,computerBalls);
            System.out.println(ballStatesInfo);

            if(ballStatesInfo.check3Strike()){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userChoice = scanner.nextInt();
            }
        }
    }
}
