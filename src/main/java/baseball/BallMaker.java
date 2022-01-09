package baseball;

import util.MyMathUtil;

import java.util.ArrayList;
import java.util.List;

public class BallMaker {
    private final int MIN_NUM;
    private final int MAX_NUM;
    private final int DIGIT_NUM;

    public BallMaker(int MIN_NUM,int MAX_NUM,int DIGIT_NUM){
        this.MIN_NUM=MIN_NUM;
        this.MAX_NUM=MAX_NUM;
        this.DIGIT_NUM=DIGIT_NUM;
    }

    public boolean checkDuplicated(int num) {
        List<Integer> list = MyMathUtil.divide(num);
        List<Integer> tmp = new ArrayList<>();

        boolean b = true;

        for(Integer integer : list){
            b = checkDuplicatedOfOneNum(integer,tmp);
            tmp.add(integer);
        }
        return b;
    }

    public boolean checkDuplicatedOfOneNum(int num, List<Integer> list) {
        return !list.contains(num);
    }

    public boolean checkRangeOfOneNum(int i) {
        return i>=MIN_NUM && i<=MAX_NUM;
    }

    public boolean checkNum(int i) {
        return MyMathUtil.checkDigit(i,DIGIT_NUM);
    }

    public boolean checkRange(int num) {
        List<Integer> list = MyMathUtil.divide(num);
        boolean b=true;

        for(Integer integer : list)
            b=checkRangeOfOneNum(integer);

        return b;
    }

    public boolean check(int num) {
        return checkDuplicated(num)&&checkNum(num)&&checkRange(num);
    }
}
