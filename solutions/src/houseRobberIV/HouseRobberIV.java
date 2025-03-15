package houseRobberIV;

import java.util.Arrays;

public class HouseRobberIV {
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    c++;
                    i++;
                }
            }
            if (c >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
