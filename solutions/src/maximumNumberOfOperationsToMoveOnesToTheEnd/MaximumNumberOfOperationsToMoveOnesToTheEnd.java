package maximumNumberOfOperationsToMoveOnesToTheEnd;

public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public int maxOperations(String s) {
        int c = 0;
        int curC = 0;
        boolean act = false;
        for (char ch : s.toCharArray()) {
            if (ch == '1' && !act) {
                curC++;
            } else if (ch == '0') {
                act = true;
            } else if (ch == '1') {
                c += curC;
                curC++;
                act = false;
            }
        }
        if (s.charAt(s.length() - 1) == '0') {
            c += curC;
        }
        return c;
    }
}
