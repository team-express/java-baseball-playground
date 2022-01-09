package baseball;

import util.MyMathUtil;

import java.util.ArrayList;
import java.util.List;

public class BallMaker {
    //이 클래스의 싱글톤화에 대한 고찰(enum과 static 안되는 이유 + 내부클래스)
    //야구 게임은 무조건 3개의수(삼진아웃) 서로다른 수(게임룰이 그렇게 임의로 짜여져 있다) 고찰.

    private final int MIN_NUM;
    private final int MAX_NUM;
    private final int DIGIT_NUM;

    public BallMaker(int MIN_NUM,int MAX_NUM,int DIGIT_NUM){
        this.MIN_NUM=MIN_NUM;
        this.MAX_NUM=MAX_NUM;
        this.DIGIT_NUM=DIGIT_NUM;
    }

    public boolean checkDuplicated(int num) {
        List<Integer> dividedNums = MyMathUtil.divide(num);
        List<Integer> dividedNumsTmp = new ArrayList<>();
        //꼭 공간낭비를 해야했을까, 일단 두겠다

        boolean checkDuplicated = false;

        for(Integer dividedNum : dividedNums){
            checkDuplicated = checkDuplicatedOfOneNum(dividedNum,dividedNumsTmp);
            dividedNumsTmp.add(dividedNum);
        }
        return checkDuplicated;
    }

    public boolean checkDuplicatedOfOneNum(int num, List<Integer> list) {
        return list.contains(num);
    }

    public boolean checkRangeOfOneNum(int num) {
        return num>=MIN_NUM && num<=MAX_NUM;
    }

    public boolean checkNum(int num) {
        return MyMathUtil.checkDigit(num,DIGIT_NUM);
    }

    public boolean checkRange(int num) {
        List<Integer> dividedNums = MyMathUtil.divide(num);
        boolean checkRange=true;

        //여기와 dupli부분의 이런 방법이 마음에 들지 않지만, 리팩토링하더라도 input/output에는 영향을 끼치지 않으므로 일단 두겠다.
        for(Integer dividedNum : dividedNums)
            checkRange=checkRangeOfOneNum(dividedNum);

        return checkRange;
    }

    public boolean check(int num) {
        return checkRange(num)&&!checkDuplicated(num)&&checkNum(num);
    }
}
