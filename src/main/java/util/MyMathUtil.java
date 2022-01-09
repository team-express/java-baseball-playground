package util;

import java.util.ArrayList;
import java.util.List;

public class MyMathUtil {
    public static boolean checkDigit(int i, int digit) {
        int n = (int)Math.pow(10,digit);
        return i/n == 0 && i/(n/10) != 0;
    }

    public static List<Integer> divide(int num) {
        List<Integer> list = new ArrayList<>();

        for(int i=1;num/i!=0;i*=10){
            list.add(0,(num/i)%10);
        }

        return list;
    }
}
