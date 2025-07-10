package nextGreaterElementI;

import java.util.*;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> containMap = new HashMap<>();
        int[] pre = new int[nums2.length];
        Deque<int[]> deq = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            pre[i] = -1;
            while (!deq.isEmpty() && deq.getLast()[1] < nums2[i]) {
                int[] poll = deq.pollLast();
                pre[poll[0]] = nums2[i];
            }
            deq.addLast(new int[] {i, nums2[i]});
        }
        for (int i = 0; i < nums2.length; i++) {
            containMap.put(nums2[i], i);
        }
        int[] answer = new int[nums1.length];
        for (int i = 0; i < answer.length; i++) {
            if (containMap.containsKey(nums1[i])) {
                answer[i] = pre[containMap.get(nums1[i])];
            }
        }
        return answer;
    }

}
