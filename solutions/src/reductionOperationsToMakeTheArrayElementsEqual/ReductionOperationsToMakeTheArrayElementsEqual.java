package reductionOperationsToMakeTheArrayElementsEqual;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {
    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int operations = 0;
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }
            operations += count;
        }

        return operations;
    }
}
