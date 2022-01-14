import java.util.*;

public class ReadyGame {

    public String inputUserNumber() {
        String userNumber;
        Scanner scanner;

        scanner = new Scanner(System.in);
        userNumber = scanner.nextLine();

        return userNumber;
    }

    public List<Integer> creatRandomNumber() {

        List<Integer> computerNumber = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(9);
            if (!(computerNumber.contains(randomNumber + 1))) {
                computerNumber.add(randomNumber + 1);
                continue;
            }
            i--;
        }
        return computerNumber;
    }

    public List<Integer> splitNumber(String userNumber) {

        List<Integer> userNumberList = new ArrayList<>();
        String[] splitUserNumber = userNumber.split("");
        for (String eachNumber : splitUserNumber) {
            userNumberList.add(Integer.parseInt(eachNumber));
        }
        return userNumberList;
    }

    public boolean validateNumber(List<Integer> userNumberList) {
        boolean verificationResult = false;

        if (!(userNumberList.size() == 3)) {
            return verificationResult;
        }

        for (Integer number : userNumberList) {
            if (!(0 < number && number < 10)) {
                return verificationResult;
            }

            if (!(Collections.frequency(userNumberList, number) == 1)) {
                return verificationResult;
            }
        }
        return true;
    }



}
