package minimumNumberOfOperationsToMakeArrayXOREqualToK;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public int minOperations(int[] nums, int k) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((a & (1 << i)) != (k & (1 << i))) {
                c++;
            }
        }
        return c;
    }
}
