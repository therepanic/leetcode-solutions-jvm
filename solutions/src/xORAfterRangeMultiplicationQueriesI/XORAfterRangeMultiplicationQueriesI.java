package xORAfterRangeMultiplicationQueriesI;

public class XORAfterRangeMultiplicationQueriesI {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int it = 0; it < queries.length; it++) {
            int idx = queries[it][0];
            while (idx <= queries[it][1]) {
                nums[idx] = (int) ((1L * nums[idx] * queries[it][3]) % (1000000007));
                idx += queries[it][2];
            }
        }
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}
