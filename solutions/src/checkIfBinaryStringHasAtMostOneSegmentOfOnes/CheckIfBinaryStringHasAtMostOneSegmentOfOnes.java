package checkIfBinaryStringHasAtMostOneSegmentOfOnes;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        boolean has = false;
        boolean act = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && !act) {
                act = true;
                if (has) {
                    return true;
                }
            } else if (s.charAt(i) == '0' && act) {
                act = false;
                has = true;
            }
        }
        return false;
    }
}
