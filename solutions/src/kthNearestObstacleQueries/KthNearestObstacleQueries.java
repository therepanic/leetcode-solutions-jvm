package kthNearestObstacleQueries;

import java.util.*;

public class KthNearestObstacleQueries {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] answer = new int[queries.length];
        int it = 0;
        for (int[] query : queries) {
            int val = Math.abs(query[0]) + Math.abs(query[1]);
            if (heap.size() < k) {
                heap.add(val);
                answer[it] = -1;
            } else if (heap.peek() > val) {
                heap.poll();
                heap.add(val);
            }
            answer[it] = heap.size() < k ? -1 : heap.peek();
            it++;
        }
        return answer;
    }
}
