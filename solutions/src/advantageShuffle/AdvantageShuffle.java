package advantageShuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            maxHeap.add(new int[] {nums2[i], i});
        }

        int l = 0;
        int r = nums1.length - 1;

        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.poll();

            int val = poll[0];
            int valIndex = poll[1];

            if (nums1[r] > val) {
                answer[valIndex] = nums1[r];
                r--;
            } else {
                answer[valIndex] = nums1[l];
                l++;
            }
        }

        return answer;
    }
}
