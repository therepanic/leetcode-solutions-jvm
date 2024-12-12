package takeGiftsFromTheRichestPile;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int gift : gifts) {
            heap.add(gift);
        }

        while (!heap.isEmpty() && k > 0) {
            int val = (int) Math.sqrt(heap.poll());

            heap.add(val);

            k--;
        }

        long sum = 0;

        while (!heap.isEmpty()) {
            sum += heap.poll();
        }

        return sum;
    }
}
