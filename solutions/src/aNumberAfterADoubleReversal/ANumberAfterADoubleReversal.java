package aNumberAfterADoubleReversal;

public class ANumberAfterADoubleReversal {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '0') {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
