package minimumDeletionsToMakeArraySharp;

public class MinimumDeletionsToMakeArraySharp {
    public int minDeletions(int[] nums) {
        int c = 0;
        int a = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != a) {
                a = nums[i];
                ans += c;
                c = 0;
            } else {
                c++;
            }
        }
        ans += c;
        return ans;
    }
}
