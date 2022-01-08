package util;

public class MyMathUtil {
    public static boolean checkDigit(int i, int digit) {
        int n = (int)Math.pow(10,digit);
        return i/n == 0 && i/(n/10) != 0;
    }
}
