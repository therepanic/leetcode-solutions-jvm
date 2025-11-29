package minimumOperationsToMakeArraySumDivisibleByK;

public class MinimumOperationsToMakeArraySumDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        return sum % k;
    }
}
