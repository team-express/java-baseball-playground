package baseball;

import util.MyMathUtil;

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

    public boolean checkRangeOfOneNum(int i) {
        return i>=MIN_NUM && i<=MAX_NUM;
    }

    public boolean checkNum(int i) {
        return MyMathUtil.checkDigit(i,DIGIT_NUM);
    }
}
