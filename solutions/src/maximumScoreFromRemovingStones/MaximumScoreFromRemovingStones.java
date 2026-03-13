package maximumScoreFromRemovingStones;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.add(a);
        heap.add(b);
        heap.add(c);
        int answer = 0;
        while (heap.size() >= 2) {
            int first = heap.poll() - 1;
            int second = heap.poll() - 1;
            if (first > 0) {
                heap.add(first);
            }
            if (second > 0) {
                heap.add(second);
            }
            answer++;
        }
        return answer;
    }
}
