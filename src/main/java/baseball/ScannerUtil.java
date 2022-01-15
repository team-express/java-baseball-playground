package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUtil {

    public List<Integer> makeScannerNumbers() {
        System.out.print("숫자를 입력하세요: ");

        ListUtil listUtil = new ListUtil();

        List<Integer> integers = stringListToIntegerList();

        while (!listUtil.checkListSize(integers)) {
            System.out.println("잘못된 숫자입니다.");
            System.out.print("숫자를 입력하세요: ");

            integers = stringListToIntegerList();
        }
        return integers;
    }

    public String insertString() {

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public int insertInt() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String[] splitStringList() {
        String string = insertString();

        return string.split("");
    }

    private List<Integer> stringListToIntegerList() {
        String[] strings = splitStringList();

        List<Integer> temp = new ArrayList<>();
        ListUtil listUtil = new ListUtil();

        for (String string : strings) {
            int number = Integer.parseInt(string);
            listUtil.distinctNumberAdd(temp, number);
        }

        return temp;
    }
}
