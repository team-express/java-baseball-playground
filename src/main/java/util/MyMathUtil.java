package util;

import java.util.ArrayList;
import java.util.List;

public class MyMathUtil {
    public static boolean checkDigit(int i, int digit) {
        int n = (int)Math.pow(10,digit);
        return i/n == 0 && i/(n/10) != 0;
    }

    public static List<Integer> divide(int num,int digit) {
        //앞에서 자릿수가 걸러져서 나오게 짤 것이므로 무조건 n자리라고 생각하여 코딩한다.
        List<Integer> list = new ArrayList<>();

        //아아..아래 메서드들로 나누기 전에 그냥 몫의 제일 끝자리만 꺼내면 되잖아..
        for(int i=1;num/i!=0;i*=10){
            list.add(0,(num/i)%10);
        }
        return list;
    }

    public static int getDigitValue(int i, int digit) {
        return 0;
    }

    public static int getDigit(int num) {
        int divisionNum=1;
        int digit=0;

        while(hasShare(num,divisionNum)){
            digit++;
            divisionNum*=10;
        }
        return digit;
    }

    public static boolean hasShare(int num, int divisionNum) {
        return num/divisionNum!=0;
    }
}
