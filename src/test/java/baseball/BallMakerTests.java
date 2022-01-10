package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.MyMathUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BallMakerTests {
    BallMaker ballMaker;

    Class clazz;
    Class[] paramTypes;
    Method method;

    @BeforeEach
    void setUp(){
        ballMaker = new BallMaker(1,9,3);
        clazz = BallMaker.class;
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false","1:true","9:true","10:false"},delimiter = ':')
    @DisplayName("한 숫자가 1~9사이의 숫자를 입력하였는지 체크")
    void testCheckRangeOfOneNum(int input, boolean output){
        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("checkRangeOfOneNum",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"012:false","123:true","230:false"},delimiter = ':')
    @DisplayName("사용자가 입력한 3숫자 모두 1~9조건을 만족하는지")
    void testCheckRange(int input, boolean output){
        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("checkRange",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"11:false","111:true","1111:false"},delimiter = ':')
    @DisplayName("사용자가 3자리수를 입력하였는지")
    void testCheckNum(int input,boolean output){

        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("checkNum",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","4:false"},delimiter = ':')
    @DisplayName("한 수가 리스트에 포함되어 있어야 함")
    void testDuplicatedOfOneNum(int input,boolean output){
        List<Integer> list = new ArrayList<>();

        if(output) list.add(input);

        try {
            paramTypes=new Class[]{int.class,List.class};
            method = clazz.getDeclaredMethod("checkDuplicatedOfOneNum",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input,list)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"123:false","121:true"},delimiter = ':')
    @DisplayName("사용자가 입력한 수가 중복되는가")
    void testCheckDuplicated(int input, boolean output){

        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("checkDuplicated",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1234:false","121:false","123:true"},delimiter = ':')
    @DisplayName("사용자가 생성한 숫자가 이 모든 조건을 만족하는가")
    void testCheck(int input, boolean output){
        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("check",paramTypes);
            method.setAccessible(true);
            assertThat(method.invoke(ballMaker,input)).isEqualTo(output);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("한 숫자 공 생성")
    void createBall(){
        try {
            paramTypes=new Class[]{int.class};
            method = clazz.getDeclaredMethod("createBall",paramTypes);
            method.setAccessible(true);
            assertThat(((Ball)method.invoke(ballMaker,3)).getNum()).isEqualTo(3);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @DisplayName("사용자 공 생성")
    @CsvSource(value = {"211:false","1234:false","346:true"},delimiter = ':')
    void testCreateUserBalls(int input,boolean output){
        assertThat(ballMaker.createUserBalls(input)!=null).isEqualTo(output);
    }

}
