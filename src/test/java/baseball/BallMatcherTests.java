package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class BallMatcherTests {
    //사용자 및 컴퓨터 각각 조건을 만족하는 숫자 3개가 담겨있는 balls가 있다.
    //두 수를 받아 n볼,n스트라이크 정보를 출력하겠다
    //      - 사용자의 수 하나(숫자와 위치)가 컴퓨터의 하나(")
    //              - 둘다 같으면 strike, 숫자만 같으면 ball, 낫띵
    Class clazz;
    Class[] paramTypes;
    Method method;

    BallMaker ballMaker;
    Balls userBalls,computerBalls;

    BallMatcher ballMatcher;
    BallStatesInfo ballStatesInfo;

    @BeforeEach
    void setUp(){
        ballMaker = new BallMaker(1,9,3);
        ballMatcher = new BallMatcher();
        ballStatesInfo = new BallStatesInfo();

        clazz = BallMatcher.class;
    }

    @Test
    @DisplayName("하나하나 비교한 구종을 바로 올린다")
    void testCountBallState(){

        userBalls = ballMaker.createUserBalls(142);
        computerBalls = ballMaker.createUserBalls(123);

        try {
            paramTypes=new Class[]{Ball.class,Ball.class, BallStatesInfo.class};
            method = clazz.getDeclaredMethod("countBallState",paramTypes);
            method.setAccessible(true);

            method.invoke(ballMatcher,userBalls.get(0),computerBalls.get(0),ballStatesInfo);
            method.invoke(ballMatcher,userBalls.get(0),computerBalls.get(1),ballStatesInfo);
            method.invoke(ballMatcher,userBalls.get(2),computerBalls.get(1),ballStatesInfo);

            assertThat(ballStatesInfo.toString()).isEqualTo("1볼 1스트라이크 ");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("사용자 볼 하나로 컴퓨터 볼들 비교하여 구종을 올린다")
    void testMakeBallStatesInfoOfOneUserBall(){
        userBalls = ballMaker.createUserBalls(142);
        computerBalls = ballMaker.createUserBalls(123);
        try {
            paramTypes=new Class[]{Ball.class,Balls.class, BallStatesInfo.class};
            method = clazz.getDeclaredMethod("makeBallStatesInfoOfOneUserBall",paramTypes);
            method.setAccessible(true);

            method.invoke(ballMatcher,userBalls.get(0),computerBalls,ballStatesInfo);
            method.invoke(ballMatcher,userBalls.get(1),computerBalls,ballStatesInfo);
            method.invoke(ballMatcher,userBalls.get(2),computerBalls,ballStatesInfo);

            assertThat(ballStatesInfo.toString()).isEqualTo("1볼 1스트라이크 ");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("전부 비교, BallStatesInfo 반환")
    void tesGetBallStatesInfo(){
        userBalls = ballMaker.createUserBalls(142);
        computerBalls = ballMaker.createUserBalls(357);
        assertThat(ballMatcher.getBallStatesInfo(userBalls,computerBalls).toString()).isEqualTo("Nothing");

        userBalls = ballMaker.createUserBalls(124);
        computerBalls = ballMaker.createUserBalls(241);
        assertThat(ballMatcher.getBallStatesInfo(userBalls,computerBalls).toString()).isEqualTo("3볼 ");

        userBalls = ballMaker.createUserBalls(142);
        computerBalls = ballMaker.createUserBalls(142);
        assertThat(ballMatcher.getBallStatesInfo(userBalls,computerBalls).toString()).isEqualTo("3스트라이크 ");

    }
}
