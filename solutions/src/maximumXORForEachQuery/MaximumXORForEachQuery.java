package maximumXORForEachQuery;

public class MaximumXORForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int[] query = new int[nums.length];
        for (int i = 0; i < query.length; i++) {
            query[i] = sum ^ ((1 << maximumBit) - 1);
            sum ^= nums[nums.length - i - 1];
        }
        return query;
    }
}
