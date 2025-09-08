package minimumNumberOfSwapsToMakeTheBinaryStringAlternating;

public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    public int minSwaps(String s) {
        char[] sChars = s.toCharArray();
        int a = minSwaps(sChars, false);
        int b = minSwaps(sChars, true);
        if (a != -1 && b == -1) {
            return a;
        } else if (a == -1 && b != -1) {
            return b;
        } else {
            return Math.min(a, b);
        }
    }

    public int minSwaps(char[] chars, boolean act) {
        int[] c = new int[2];
        for (int i = 0; i < chars.length; i++) {
            if (!act && chars[i] == '1') {
                c[1]++;
                act = true;
            } else if (act && chars[i] == '0') {
                c[0]++;
                act = false;
            } else {
                act = !act;
            }
        }
        return c[0] != c[1] ? -1 : c[0];
    }
}
