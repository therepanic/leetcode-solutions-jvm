package specialArrayII;

public class SpecialArrayII {

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0);
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == query[1] || dp[query[1]] - dp[query[0]] == 0) {
                answer[i] = true;
            }
        }
        return answer;
    }
}
