package sumOfGoodNumbers;

public class SumOfGoodNumbers {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && nums[i] <= nums[i - k]) {
                continue;
            }
            if (i + k < nums.length && nums[i] <= nums[i + k]) {
                continue;
            }
            a += nums[i];
        }
        return a;
    }
}
