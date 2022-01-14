package baseball;

import util.MyMathUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BallMaker {
    //이 클래스의 싱글톤화에 대한 고찰(enum과 static 안되는 이유 + 내부클래스)
    //야구 게임은 무조건 3개의수(삼진아웃) 서로다른 수(게임룰이 그렇게 임의로 짜여져 있다) 고찰.
    //maker와 checker로 나눌까

    private final int MIN_NUM;
    private final int MAX_NUM;
    private final int DIGIT_NUM;

    public BallMaker(int MIN_NUM,int MAX_NUM,int DIGIT_NUM){
        this.MIN_NUM=MIN_NUM;
        this.MAX_NUM=MAX_NUM;
        this.DIGIT_NUM=DIGIT_NUM;
    }

    private boolean checkDuplicated(int num) {
        List<Integer> dividedNums = MyMathUtil.divide(num);
        List<Integer> dividedNumsTmp = new ArrayList<>();

        boolean checkDuplicated = false;

        for(int i=0;i<dividedNums.size() && !checkDuplicated;i++){
            int dividedNum = dividedNums.get(i);
            checkDuplicated = checkDuplicatedOfOneNum(dividedNum,dividedNumsTmp);
            dividedNumsTmp.add(dividedNum);
        }
        return checkDuplicated;
    }

    private boolean checkDuplicatedOfOneNum(int num, List<Integer> list) {
        return list.contains(num);
    }

    private boolean checkRangeOfOneNum(int num) {
        return num>=MIN_NUM && num<=MAX_NUM;
    }

    private boolean checkNum(int num) {
        return MyMathUtil.checkDigit(num,DIGIT_NUM);
    }

    private boolean checkRange(int num) {
        List<Integer> dividedNums = MyMathUtil.divide(num);
        boolean checkRange=true;

        for(int i=0;i<dividedNums.size() && checkRange;i++){
            checkRange = checkRangeOfOneNum(dividedNums.get(i));
        }

        return checkRange;
    }

    private boolean check(int num) {
        return checkRange(num)&&(!checkDuplicated(num))&&checkNum(num);
    }

    public Balls createUserBalls(int num) {

        if(!check(num))
            return null;

        List<Integer> dividedNums = MyMathUtil.divide(num);
        List<Ball> balls = new ArrayList<>();
        for (Integer dividedNum : dividedNums)
            balls.add(createBall(dividedNum));

        return new Balls(balls);
    }

    private Ball createBall(int num) {
        return new Ball(num);
    }

    public Balls createComputerBalls(){
        List<Integer> list = new ArrayList<>();
        List<Ball> balls = new ArrayList<>();

        while(balls.size()<DIGIT_NUM) {
            Ball ball = createComputerBall(list);
            balls.add(ball);
            list.add(ball.getNum());
        }
        return new Balls(balls);
    }

    private Ball createComputerBall(List<Integer> list){
        int num = (int) (Math.random() * MAX_NUM) + MIN_NUM;

        while(checkDuplicatedOfOneNum(num, list)){
            num = (int) (Math.random() * MAX_NUM) + MIN_NUM;
        }

        return new Ball(num);
    }
}
