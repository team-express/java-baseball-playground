package util;

import java.util.ArrayList;
import java.util.List;

public class MyMathUtil {
    //check는 긍정으로 통일하기로 했다
    //성능과 가독성이 함께하지 않을 경우가 있다
    private static final int DECIMAL_NUM=10;
    private static final int ZERO=0;

    public static boolean checkDigit(int num, int digit) {
        int n = num/(int)Math.pow(DECIMAL_NUM,digit-1);
        return n/DECIMAL_NUM == ZERO && n != ZERO;
    }

    public static List<Integer> divide(int num) {
        List<Integer> list = new ArrayList<>();

        int share = num*DECIMAL_NUM;
        while((share/=DECIMAL_NUM)!=ZERO){
            list.add(ZERO,(share)%DECIMAL_NUM);
        }

        return list;
    }
}
