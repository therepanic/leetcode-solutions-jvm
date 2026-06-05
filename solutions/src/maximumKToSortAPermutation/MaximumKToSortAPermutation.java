package maximumKToSortAPermutation;

public class MaximumKToSortAPermutation {
    public int sortPermutation(int[] nums) {
        int a = ~0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                a &= nums[i];
            }
        }
        return a;
    }
}
