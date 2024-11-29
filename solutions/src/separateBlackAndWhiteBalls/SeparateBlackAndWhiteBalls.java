package separateBlackAndWhiteBalls;

import java.util.Arrays;

public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
        System.out.println(minimumSteps("101"));
    }
    public static long minimumSteps(String s) {
        char[] chars = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;

        long count = 0;

        while (l < r) {
            while (l < r && chars[r] == '1') {
                r--;
            }

            if (chars[l] != '0') {
                count += r - l;
                r--;
            }

            l++;
        }

        return count;
    }
}
