package baseball;

import java.util.List;

public class Referee {

    public int countBall(List<Integer> list1, List<Integer> list2) {

        int count = 0;
        int strike = countStrike(list1, list2);

        for (Integer number : list1) {
            count = getCount(list2, count, number);
        }
        return count - strike;
    }

    public int countStrike(List<Integer> list1, List<Integer> list2) {

        int count = 0;
        for (int index = 0; index < 3; index++) {
            count = getCountStrike(list1, list2, count, index);
        }
        return count;
    }

    public String informStrikeBall(List<Integer> list1, List<Integer> list2) {

        int ball = countBall(list1, list2);
        int strike = countStrike(list1, list2);

        if (strike == 3) {
            return strike + "스트라이크";
        }

        if (strike == 0 && ball != 0) {
            return ball + "볼";
        }

        if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }

        return "낫싱";
    }

    private int getCountStrike(List<Integer> list1, List<Integer> list2, int count, int index) {
        if (list1.get(index) == list2.get(index)) {
            count++;
        }
        return count;
    }

    private int getCount(List<Integer> list2, int count, Integer number) {
        if (list2.contains(number)) {
            count++;
        }
        return count;
    }

}
