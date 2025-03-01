package applyOperationsToAnArray;

public class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int it = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[it] = nums[i];
                it++;
            }
        }
        return res;
    }
}
