package countConsistentSubarraysI;

public class CountConsistentSubarraysI {
    public int countConsistent(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = ~0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                a &= nums[j];
                min = Math.min(min, nums[j]);
                if (a == min) {
                    c++;
                }
            }
        }
        return c;
    }
}
