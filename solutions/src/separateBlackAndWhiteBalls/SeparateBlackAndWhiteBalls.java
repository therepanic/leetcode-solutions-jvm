package separateBlackAndWhiteBalls;

public class SeparateBlackAndWhiteBalls {
    public static long minimumSteps(String s) {
        char[] chars = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;

        long count = 0;

        while (l < r) {
            if (chars[r] == '1') {
                r--;
                continue;
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
