package minimumOperationsToSortWithLockedIndices;

public class MinimumOperationsToSortWithLockedIndices {
    public int minOperations(int[] nums, int[] locked, int k) {
        int lock = 0;
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                    ops++;
                    if (locked[i] == 1) {
                        lock++;
                        ops++;
                        locked[i] = 0;
                    }
                    if (locked[j] == 1) {
                        lock++;
                        ops++;
                        locked[j] = 0;
                    }
                    if (lock > k) {
                        return -1;
                    }
                }
            }
        }
        return ops;
    }
}
