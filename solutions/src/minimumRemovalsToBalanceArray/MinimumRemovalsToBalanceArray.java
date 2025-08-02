package minimumRemovalsToBalanceArray;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1;
            int last = i;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) nums[mid] <= (long) nums[i] * k) {
                    last = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res = Math.min(res, n - (last - i + 1));
        }
        return res;
    }
}
