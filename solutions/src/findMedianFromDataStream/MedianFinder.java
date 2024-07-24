package findMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (minHeap.size() <= maxHeap.size()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (maxHeap.peek() != null && minHeap.peek() != null) {
            if (minHeap.peek() < maxHeap.peek()) {
                int minBuffer = minHeap.poll();
                int maxBuffer = maxHeap.poll();

                minHeap.add(maxBuffer);
                maxHeap.add(minBuffer);
            }
        }

        if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            int first = minHeap.peek() == null ? 0 : minHeap.peek();
            int sec = maxHeap.peek() == null ? 0 : maxHeap.peek();

            return (double) (first + sec) / 2;
        } else {
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
