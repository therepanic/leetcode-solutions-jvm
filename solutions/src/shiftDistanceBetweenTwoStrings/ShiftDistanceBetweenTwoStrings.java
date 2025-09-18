package shiftDistanceBetweenTwoStrings;

public class ShiftDistanceBetweenTwoStrings {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[] nextSum = new long[27];
        long[] prevSum = new long[27];
        for (int i = 0; i < 26; i++) {
            nextSum[i + 1] = nextSum[i] + nextCost[i];
            prevSum[i + 1] = prevSum[i] + previousCost[i];
        }
        long c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) continue;
            long min = charNeed(s.charAt(i), t.charAt(i), nextSum, prevSum);
            c += min;
        }
        return c;
    }

    public long charNeed(char from, char to, long[] nextSum, long[] prevSum) {
        long c1 = 0;
        long c2 = 0;
        int start = from - 'a';
        int end = to - 'a';
        if (start == end) return 0;
        if (start > end) {
            c1 = prevSum[start + 1] - prevSum[end + 1];
            c2 = (nextSum[26] - nextSum[start]) + nextSum[end];
        } else {
            c1 = prevSum[start + 1] + (prevSum[26] - prevSum[end + 1]);
            c2 = nextSum[end] - nextSum[start];
        }
        return Math.min(c1, c2);
    }
}
