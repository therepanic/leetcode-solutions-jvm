package numberOfSubarraysThatMatchAPatternI;

public class NumberOfSubarraysThatMatchAPatternI {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int c = 0;
        int m = pattern.length;
        int l = 0;
        for (int r = m; r < nums.length; r++, l++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (pattern[j] == 1) {
                    if (nums[l + j + 1] <= nums[l + j]) {
                        flag = false;
                        break;
                    }
                } else if (pattern[j] == 0) {
                    if (nums[l + j + 1] != nums[l + j]) {
                        flag = false;
                        break;
                    }
                } else {
                    if (nums[l + j + 1] >= nums[l + j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                c++;
            }
        }
        return c;
    }
}
