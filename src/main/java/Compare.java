import java.util.Collections;
import java.util.List;

public class Compare {

    public int checkSameNumber(List<Integer> userNumberList, List<Integer> computerNumberList) {

        int sameNumberCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            sameNumberCount += countSameNumber(userNumberList, computerNumberList.get(i));
        }
        return sameNumberCount;
    }

    private int countSameNumber(List<Integer> userNumberList, int compareNumber) {
        return Collections.frequency(userNumberList, compareNumber);
    }

    public int checkSameLocation(List<Integer> userNumberList, List<Integer> computerNumberList) {

        int sameLocationNumberCount = 0;

        for (int i = 0; i < userNumberList.size(); i++) {
            sameLocationNumberCount += CountSameLocationNumber((userNumberList.get(i)), computerNumberList.get(i));
        }
        return sameLocationNumberCount;
    }

    private int CountSameLocationNumber(int userNumber, int computerNumber) {
        if (userNumber == computerNumber) {
            return 1;
        }
        return 0;
    }

    public String refereeGame(int sameNumberAmount, int sameLocationNumberAmount) {

        int ball = sameNumberAmount - sameLocationNumberAmount;
        int strike = sameLocationNumberAmount;

        if (ball ==0 && strike ==0) {
        return "낫싱";
        }

        if (ball ==3 && strike ==3) {
            return "아웃!";
        }

        return strike + " 스트라이크 "+ball+" 볼";
    }
}
