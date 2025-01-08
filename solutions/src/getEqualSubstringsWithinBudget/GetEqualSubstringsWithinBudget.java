package getEqualSubstringsWithinBudget;

public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int curMaxCost = 0;

        int l = 0;

        int maxSubstrSize = 0;

        for (int r = 0; r < s.length(); r++) {
            curMaxCost += Math.abs(sChars[r] - tChars[r]);

            while (curMaxCost > maxCost) {
                curMaxCost -= Math.abs(sChars[l] - tChars[l]);
                l++;
            }

            maxSubstrSize = Math.max(r - l + 1, maxSubstrSize);
        }

        return maxSubstrSize;
    }
}
