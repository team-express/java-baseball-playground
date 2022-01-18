package baseball;

import java.util.Scanner;

public class BallGame {
    private Scanner scanner;

    private BallMaker ballMaker;
    private BallMatcher ballMatcher;

    private Balls computerBalls,userBalls;

    private BallStatesInfo ballStatesInfo;

    public BallGame(){
        scanner = new Scanner(System.in);
        ballMaker = new BallMaker(1,9,3);
        ballMatcher = new BallMatcher();
        computerBalls = ballMaker.createComputerBalls();
    }

    public void play(){
        boolean flag = true;

        while(flag){
            System.out.print("숫자를 입력해 주세요 : ");
            userBalls = ballMaker.createUserBalls(scanner.nextInt());

            ballStatesInfo = ballMatcher.getBallStatesInfo(userBalls,computerBalls);

            System.out.println(ballStatesInfo);

            flag = getFlag();
        }
    }

    public static void main(String[] args) {
        new BallGame().play();
    }
    private boolean getFlag(){
        boolean flag=true;

        if(ballStatesInfo.check3Strike()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag = scanner.nextInt()==1;
            computerBalls = ballMaker.createComputerBalls();
        }

        return flag;
    }
}
