package baseball;

import util.MyMathUtil;

import java.util.ArrayList;
import java.util.List;

public class BallMaker {
    //싱글톤으로 만들고 싶다.
    private final int MIN_NUM;
    private final int MAX_NUM;
    private final int DIGIT_NUM;

    public BallMaker(int MIN_NUM,int MAX_NUM,int DIGIT_NUM){
        this.MIN_NUM=MIN_NUM;
        this.MAX_NUM=MAX_NUM;
        this.DIGIT_NUM=DIGIT_NUM;
    }

    public boolean checkDuplicated(int num) {
        //꼭 공간을 낭비하였어야 했던가?
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

    //String.charAt - parse 버전도 만들어 보자
    public boolean checkRange(int num) {
        List<Integer> list = MyMathUtil.divide(num);
        boolean b=true;

        //아 근데 이것도 duplicate도 맘에 안든다
        for(Integer integer : list)
            b=checkRangeOfOneNum(integer);

        return b;
    }

    public boolean check(int num) {
        //이렇게 밖에 할 수 없었나, 섞으며 할 수 없으려나
        return checkDuplicated(num)&&checkNum(num)&&checkRange(num);
    }
}
