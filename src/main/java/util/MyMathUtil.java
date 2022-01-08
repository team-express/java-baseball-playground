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

        //더 좋은 방법 없을까
        //digit을 받아서 카운트처리?
        //digit받지않고 할만한..방법
        for(int i=1;num/i!=0;i*=10){
            list.add(0,(num/i)%10);
        }
        return list;
    }
}
