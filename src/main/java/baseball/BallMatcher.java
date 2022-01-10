package baseball;

public class BallMatcher {

    private BallState getBallState(Ball userBall,Ball computerBall){
        if(userBall.equals(computerBall))
            return BallState.STRIKE;
        if(userBall.getNum() == computerBall.getNum())
            return BallState.BALL;
        return BallState.NOTHING;
    }
}
