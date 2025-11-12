package minimumDistanceBetweenThreeEqualElementsII;

import java.util.*;

public class MinimumDistanceBetweenThreeEqualElementsII {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> valMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            valMap.computeIfAbsent(nums[i], p -> new int[] {-1, -1, -1});
            int[] arr = valMap.get(nums[i]);
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = i;
            if (arr[0] != -1 && arr[1] != -1) {
                ans = Math.min(ans, Math.abs(arr[0] - arr[1]) + Math.abs(arr[1] - arr[2]) + Math.abs(arr[2] - arr[0]));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
