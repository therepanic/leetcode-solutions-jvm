package maximumDifferenceByRemappingADigit;

public class MaximumDifferenceByRemappingADigit {
    public int minMaxDifference(int num) {
        String sNum = String.valueOf(num);
        String sNumSec = sNum;
        int it = 0;
        for (int i = 0; i < sNum.length(); i++) {
            if (sNum.charAt(i) != '9') {
                it = i;
                break;
            }
        }
        sNum = sNum.replaceAll(sNum.charAt(it) + "", "9");
        sNumSec = sNumSec.replaceAll(sNumSec.charAt(0) + "", "0");
        return Integer.parseInt(sNum) - Integer.parseInt(sNumSec);
    }
}
