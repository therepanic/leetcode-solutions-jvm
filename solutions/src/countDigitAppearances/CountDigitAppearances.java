package countDigitAppearances;

public class CountDigitAppearances {
    public static int countDigitOccurrences(int[] nums, int digit) {
        int c = 0;
        for (int v : nums) {
            String p = String.valueOf(v);
            for (int i = 0; i < p.length(); i++) {
                if ((int) (p.charAt(i) - '0') == digit) {
                    c++;
                }
            }
        }
        return c;
    }
}
