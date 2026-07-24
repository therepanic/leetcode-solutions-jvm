package findPivotIndex;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] right = new int[nums.length];
        right[right.length - 1] = nums[nums.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = nums[i] + right[i + 1];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && sum == right[i + 1]) {
                return i;
            }
            if (i == nums.length - 1 && sum == 0) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
