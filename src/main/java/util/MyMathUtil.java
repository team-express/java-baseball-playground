package util;

import java.util.ArrayList;
import java.util.List;

public class MyMathUtil {
    private static final int DECIMAL_NUM=10;
    private static final int ZERO=0;
    //야구 게임은 무조건 3개의수(삼진아웃) 서로다른 수(게임룰이 그렇게 임의로 짜여져 있다) 고찰.

    //객체생성 제어
    private MyMathUtil(){}

    //성능과 가독성이 함께하지 않을 경우가 있다
    public static boolean checkDigit(int num, int digit) {
        int n = num/(int)Math.pow(DECIMAL_NUM,digit-1);
        return n/DECIMAL_NUM == ZERO && n != ZERO;
    }

    public static List<Integer> divide(int num) {
        List<Integer> list = new ArrayList<>();

        int share = num*DECIMAL_NUM;
        while((share/=DECIMAL_NUM)!=ZERO){
            list.add(ZERO,share%DECIMAL_NUM);
        }

        return list;
    }
}
