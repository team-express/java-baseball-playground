package baseball;

public class BallMatcher {

    private void countBallState(Ball userBall,Ball computerBall, BallStatesInfo ballStatesInfo){
        if(userBall.equals(computerBall)) {
            ballStatesInfo.countUp(BallState.STRIKE);
            return;
        }
        if(userBall.getNum() == computerBall.getNum()){
            ballStatesInfo.countUp(BallState.BALL);
            return;
        }
    }
    private void makeBallStatesInfoOfOneUserBall(Ball userBall, Balls computerBalls, BallStatesInfo ballStatesInfo){
        for(int i=0;i<computerBalls.getSize();i++){
            countBallState(userBall,computerBalls.get(i),ballStatesInfo);
        }
    }

    public BallStatesInfo getBallStatesInfo(Balls userBalls,Balls computerBalls) {
        BallStatesInfo ballStatesInfo = new BallStatesInfo();

        for(int i=0;i<userBalls.getSize();i++){
            makeBallStatesInfoOfOneUserBall(userBalls.get(i),computerBalls,ballStatesInfo);
        }
        return ballStatesInfo;
    }
}
