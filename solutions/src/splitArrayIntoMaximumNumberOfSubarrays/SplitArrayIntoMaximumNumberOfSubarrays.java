package splitArrayIntoMaximumNumberOfSubarrays;

public class SplitArrayIntoMaximumNumberOfSubarrays {
    public int maxSubarrays(int[] nums) {
        int a = ~0;
        for (int i = 0; i < nums.length; i++) {
            a &= nums[i];
        }
        int c = 0;
        int d = ~0;
        for (int i = 0; i < nums.length; i++) {
            d &= nums[i];
            if (d == a) {
                c++;
                d = ~0;
            }
        }
        return a == 0 ? c : 1;
    }
}
