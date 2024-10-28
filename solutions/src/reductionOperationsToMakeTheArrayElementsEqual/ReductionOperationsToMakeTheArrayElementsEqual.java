package reductionOperationsToMakeTheArrayElementsEqual;

import java.util.Arrays;

public class ReductionOperationsToMakeTheArrayElementsEqual {
    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[] {7,9,10,8,6,4,1,5,2,3}));
    }
    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int operations = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                count++;
            }
            operations += count;
        }

        return operations;
    }
}
