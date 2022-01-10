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

    @BeforeEach
    void setUp(){
        ballMaker = new BallMaker(1,9,3);
        ballMatcher = new BallMatcher();
        clazz = BallMatcher.class;
    }

    @Test
    @DisplayName("하나씩 숫자,위치로 구종 반환")
    void testGetBallState(){

        userBalls = ballMaker.createUserBalls(142);
        computerBalls = ballMaker.createUserBalls(123);

        try {
            paramTypes=new Class[]{Ball.class,Ball.class};
            method = clazz.getDeclaredMethod("getBallState",paramTypes);
            method.setAccessible(true);

            assertThat(method.invoke(ballMatcher,userBalls.get(0),computerBalls.get(0))).isEqualTo(BallState.STRIKE);
            assertThat(method.invoke(ballMatcher,userBalls.get(0),computerBalls.get(1))).isEqualTo(BallState.NOTHING);
            assertThat(method.invoke(ballMatcher,userBalls.get(2),computerBalls.get(1))).isEqualTo(BallState.BALL);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("각각의 전부 볼 구종 위치 구하여 BallStatesInfo 반환")
    void tesGetBallStatesInfo(){
        
    }
}
