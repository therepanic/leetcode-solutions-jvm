package rangeSumQueryImmutable;

public class NumArray {

    private final int[] prefixSum;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.prefixSum = nums;
    }

    public int sumRange(int left, int right) {
        int sum = this.prefixSum[right];
        if (left - 1 >= 0) {
            sum -= this.prefixSum[left - 1];
        }
        return sum;
    }

}
