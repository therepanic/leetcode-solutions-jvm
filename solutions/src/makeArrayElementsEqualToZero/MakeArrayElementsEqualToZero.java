package makeArrayElementsEqualToZero;

public class MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (go(nums.clone(), i, false)) c++;
                if (go(nums.clone(), i, true)) c++;
            }
        }
        return c;
    }

    public boolean go(int[] nums, int i, boolean dir) {
        while (i >= 0 && i < nums.length) {
            if (dir) {
                if (nums[i] > 0) {
                    nums[i]--;
                    dir = false;
                    i--;
                    continue;
                }
                i++;
            } else {
                if (nums[i] > 0) {
                    nums[i]--;
                    dir = true;
                    i++;
                    continue;
                }
                i--;
            }
        }
        for (int it = 0; it < nums.length; it++) {
            if (nums[it] > 0) return false;
        }
        return true;
    }
}
