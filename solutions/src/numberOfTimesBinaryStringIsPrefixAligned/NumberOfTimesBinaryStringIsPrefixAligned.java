package numberOfTimesBinaryStringIsPrefixAligned;

public class NumberOfTimesBinaryStringIsPrefixAligned {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0;
        int max = -1;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(max, flips[i]);
            if (i + 1 == max) {
                ans++;
            }
        }
        return ans;
    }
}
