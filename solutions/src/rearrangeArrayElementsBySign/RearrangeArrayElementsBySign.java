package rearrangeArrayElementsBySign;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int it = 0;
        int bannedIt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                bannedIt = i;
                ans[it] = nums[i];
                it++;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (bannedIt == i) continue;
            if (nums[i] < 0) {
                ans[it] = nums[i];
                it += 2;
            }
            if (it >= nums.length) break;
        }
        it = 2;
        for (int i = 0; i < nums.length; i++) {
            if (bannedIt == i) continue;
            if (nums[i] >= 0) {
                ans[it] = nums[i];
                it += 2;
            }
            if (it >= nums.length) break;
        }
        return ans;
    }
}
