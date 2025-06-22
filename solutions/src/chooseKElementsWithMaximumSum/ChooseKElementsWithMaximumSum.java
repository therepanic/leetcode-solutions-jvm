package chooseKElementsWithMaximumSum;

import java.util.*;

public class ChooseKElementsWithMaximumSum {

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int[][] nums1Sorted = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            nums1Sorted[i] = new int[] {nums1[i], i};
        }
        Arrays.sort(nums1Sorted, Comparator.comparingInt(p -> p[0]));
        PriorityQueue<int[]> nums2Heap = new PriorityQueue<>(Comparator.comparingInt(p -> nums2[p[0]]));
        long[] ans = new long[nums1.length];
        long all = 0;
        List<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            int index = nums1Sorted[i][1];
            ans[index] = all;
            buffer.add(index);
            boolean isNewGroup = i == nums1.length - 1 || nums1Sorted[i][0] != nums1Sorted[i + 1][0];
            if (isNewGroup) {
                for (int idx : buffer) {
                    if (nums2Heap.size() >= k && nums2[idx] > nums2[nums2Heap.peek()[0]]) {
                        all -= nums2[nums2Heap.poll()[0]];
                        nums2Heap.add(new int[] {idx});
                        all += nums2[idx];
                    } else if (nums2Heap.size() < k) {
                        nums2Heap.add(new int[] {idx});
                        all += nums2[idx];
                    }
                }
                buffer.clear();
            }
        }
        return ans;
    }

}
