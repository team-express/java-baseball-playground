package baseball;

import util.MyMathUtil;

public class BallMaker {
    private static final int MIN_NUM=1;
    private static final int MAX_NUM=9;
    private static final int DIGIT_NUM=3;
    //범위와 자릿수는 얼마든지 바뀔 수 있으니 빼두었다.

    public boolean checkRange(int i) {
        //return i>=1 && i<=9;
        return i>=MIN_NUM && i<=MAX_NUM;
    }

    public boolean checkNum(int i) {
        //return i/100 != 0 && i/1000 == 0;

        return MyMathUtil.checkDigit(i,DIGIT_NUM);
    }
}
