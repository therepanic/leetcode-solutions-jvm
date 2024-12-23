package kClosestPointsToOrigin;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingDouble(p -> p[0]));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            heap.add(new int[] {((int) Math.pow(point[0], 2)) + (int) Math.pow(point[1], 2), i});
        }

        int[][] answer = new int[k][2];

        for (int i = 0; i < k; i++) {
            int it = heap.poll()[1];

            answer[i][0] = points[it][0];
            answer[i][1] = points[it][1];
        }

        return answer;
    }
}
