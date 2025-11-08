package countSubarraysWithMajorityElementI;

public class CountSubarraysWithMajorityElementI {
    public int countMajoritySubarrays(int[] nums, int target) {
        int tCount = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                tCount++;
                ans++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target) {
                    tCount++;
                }
                if (Math.floor((float) (j - i + 1) / 2) < tCount) {
                    ans++;
                }
            }
            tCount = 0;
        }
        return ans;
    }
}
