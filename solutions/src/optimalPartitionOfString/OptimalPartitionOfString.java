package optimalPartitionOfString;

import java.util.Arrays;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        char[] sChars = s.toCharArray();
        int c = 1;
        boolean[] has = new boolean[26];
        for (char ch : sChars) {
            int index = ch - 'a';
            if (has[index]) {
                Arrays.fill(has, false);
                c++;
            }
            has[index] = true;
        }
        return c;
    }
}
