package minimumDeletionCostToMakeAllCharactersEqual;

public class MinimumDeletionCostToMakeAllCharactersEqual {
    public long minCost(String s, int[] cost) {
        int n = cost.length;
        long sum = 0;
        long[] count = new long[26];
        for (int i = 0; i < n; i++) {
            sum += cost[i];
            char ch = s.charAt(i);
            count[ch - 'a'] += cost[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            ans = Math.min(ans, sum - count[i]);
        }
        return ans;
    }
}
