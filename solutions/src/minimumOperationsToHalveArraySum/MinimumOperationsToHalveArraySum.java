package minimumOperationsToHalveArraySum;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            sum += num;
            maxHeap.add((double) num);
        }
        double neededSum = sum / 2;
        int c = 0;
        while (!maxHeap.isEmpty() && sum > neededSum) {
            double poll = maxHeap.poll();
            double ready = poll / 2;
            sum -= poll;
            sum += ready;
            maxHeap.add(ready);
            c++;
        }
        return c;
    }
}
