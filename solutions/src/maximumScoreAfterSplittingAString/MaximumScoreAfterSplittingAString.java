package maximumScoreAfterSplittingAString;

public class MaximumScoreAfterSplittingAString {
    public static int maxScore(String s) {
        int zeroCount = 0;
        int oneCount = 0;

        char[] sChars = s.toCharArray();

        for (char c : sChars) {
            if (c == '1') {
                oneCount++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < sChars.length - 1; i++) {
            char c = sChars[i];

            if (c == '1') {
                oneCount--;
            } else if (c == '0') {
                zeroCount++;
            }

            max = Math.max(zeroCount + oneCount, max);
        }

        return max;
    }
}
