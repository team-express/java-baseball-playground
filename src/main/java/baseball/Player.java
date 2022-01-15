package baseball;

import java.util.List;

public class Player {

    public List<Integer> makeNumbers() {

        ScannerUtil scannerUtil = new ScannerUtil();

        List<Integer> integers = scannerUtil.makeScannerNumbers();

        return integers;
    }
}
