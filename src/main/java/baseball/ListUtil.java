package baseball;

import java.util.List;

public class ListUtil {

    public boolean checkListSize(List<Integer> list) {
        return list.size() == 3;
    }

    public void distinctNumberAdd(List<Integer> numberList, int randomNumber) {
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber);
        }
    }
}
