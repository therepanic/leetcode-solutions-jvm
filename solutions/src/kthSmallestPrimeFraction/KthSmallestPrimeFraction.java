package kthSmallestPrimeFraction;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(p -> p[0]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                minHeap.add(new double[] {(double) arr[i] / arr[j], arr[i], arr[j]});
            }
        }
        while (k != 1) {
            minHeap.poll();
            k--;
        }
        double[] poll = minHeap.poll();
        return new int[] {(int) poll[1], (int) poll[2]};
    }
}
