package util;

public class MyMathUtil {
    public static boolean checkDigitUpper(int i, int digit) {
        return i/(int)Math.pow(10,digit) == 0;
    }

    public static boolean checkDigitLower(int i, int digit) {
        return i/(int)Math.pow(10,digit-1) != 0;
    }

    public static boolean checkDigit(int i, int digit) {
        //return checkDigitLower(i,digit)&&checkDigitUpper(i,digit);

        //두개로 나눌 필요가 없었구나..

        //refactoring - 1
        //return i/(int)Math.pow(10,digit) == 0 && i/(int)Math.pow(10,digit-1) != 0;

        //refactoring - 2
        int n = (int)Math.pow(10,digit);
        return i/n == 0 && i/(n/10) != 0;
    }
}
