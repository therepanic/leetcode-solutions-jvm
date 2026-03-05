package minimumChangesToMakeAlternatingBinaryString;

public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        char[] str = s.toCharArray();
        return Math.min(check(str, false), check(str, true));
    }

    public int check(char[] str, boolean oneFirst) {
        int c = 0;
        for (int i = 0; i < str.length; i++) {
            if (oneFirst && str[i] == '0') {
                c++;
            } else if (!oneFirst && str[i] == '1') {
                c++;
            }
            oneFirst = !oneFirst;
        }
        return c;
    }
}
