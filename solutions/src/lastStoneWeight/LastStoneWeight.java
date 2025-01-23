package lastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int f = maxHeap.poll();
            int s = maxHeap.poll();
            if (f != s) {
                maxHeap.add(f - s);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}
