package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> makeNumbers() {
        RandomNumber randomNumber = new RandomNumber();

        ListUtil listUtil = new ListUtil();

        List<Integer> computerNumbers = new ArrayList<>();

        while (!listUtil.checkListSize(computerNumbers)) {
            int number = randomNumber.make();
            listUtil.distinctNumberAdd(computerNumbers, number);
        }

        System.out.println("computerNumbers = " + computerNumbers);
        return computerNumbers;
    }
}
