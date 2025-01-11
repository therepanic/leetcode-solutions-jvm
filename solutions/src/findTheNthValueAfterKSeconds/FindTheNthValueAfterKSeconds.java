package findTheNthValueAfterKSeconds;

import java.util.Arrays;

public class FindTheNthValueAfterKSeconds {
    public int valueAfterKSeconds(int n, int k) {
        int[] nums = new int[n];
        Arrays.fill(nums ,1);

        for (int i = 0 ; i <= k; i++) {
            for (int j = 1; j < nums.length; j++) {
                nums[j] = (int) ((long) nums[j] + nums[j - 1]) % (1_000_000_000 + 7);
            }
        }
        return nums[nums.length - 1];
    }
}
