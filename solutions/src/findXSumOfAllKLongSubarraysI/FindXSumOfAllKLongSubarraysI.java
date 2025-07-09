package findXSumOfAllKLongSubarraysI;

import java.util.*;

public class FindXSumOfAllKLongSubarraysI {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] ans = new int[n - k + 1];
        int it = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            int perC = countMap.getOrDefault(nums[r], 0) + 1;
            countMap.put(nums[r], perC);
            if (r - l + 1 > k) {
                int c = countMap.get(nums[l]) - 1;
                if (c == 0) {
                    countMap.remove(nums[l]);
                } else {
                    countMap.put(nums[l], c);
                }
                l++;
            }
            if (r - l + 1 == k) {
                int sum = 0;
                PriorityQueue<int[]> valHeap = new PriorityQueue<>((p1, p2) -> p1[1] == p2[1] ? p2[0] - p1[0] : p2[1] - p1[1]);
                for (var entry : countMap.entrySet()) {
                    valHeap.add(new int[] {entry.getKey(), entry.getValue()});
                }
                for (int i = 0; i < x && !valHeap.isEmpty(); i++) {
                    int[] poll = valHeap.poll();
                    sum += poll[0] * poll[1];
                }
                ans[it] = sum;
                it++;
            }
        }
        return ans;
    }

}
