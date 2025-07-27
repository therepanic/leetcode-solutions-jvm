package countHillsAndValleysInAnArray;

public class CountHillsAndValleysInAnArray {

    public static int countHillValley(int[] nums) {
        int count = 0;
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[r - 1]) {
                int v = r - 1;
                if (v > 0) {
                    if ((nums[v] > nums[l] && nums[v] > nums[r]) || (nums[v] < nums[l] && nums[v] < nums[r])) {
                        count++;
                    }
                }
                l = v;
            }
        }
        return count;
    }

}
