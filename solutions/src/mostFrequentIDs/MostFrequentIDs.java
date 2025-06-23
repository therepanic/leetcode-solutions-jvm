package mostFrequentIDs;

import java.util.*;

public class MostFrequentIDs {

    public static long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Long, Long> addMap = new HashMap<>();
        PriorityQueue<long[]> heap = new PriorityQueue<>((p1, p2) -> Long.compare(p2[0], p1[0]));
        long[] answer = new long[freq.length];
        for (int i = 0; i < nums.length; i++) {
            long f = addMap.getOrDefault((long) nums[i], 0L) + freq[i];
            addMap.put((long) nums[i], f);
            heap.add(new long[] {f, (long) nums[i]});
            while (!heap.isEmpty()) {
                if (addMap.containsKey(heap.peek()[1]) && addMap.get(heap.peek()[1]) != heap.peek()[0]) {
                    heap.poll();
                } else {
                    answer[i] = heap.peek()[0];
                    break;
                }
            }
        }
        return answer;
    }

}
