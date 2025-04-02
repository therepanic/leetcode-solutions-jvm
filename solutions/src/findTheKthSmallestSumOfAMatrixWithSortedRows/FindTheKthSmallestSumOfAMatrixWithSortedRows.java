package findTheKthSmallestSumOfAMatrixWithSortedRows;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheKthSmallestSumOfAMatrixWithSortedRows {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.add(0);
        for (int i = 0 ; i < mat.length; i++) {
            PriorityQueue<Integer> temp = new PriorityQueue<>(Comparator.reverseOrder());
            int sz = heap.size();
            for (int j = 0; j < sz; j++) {
                int poll = heap.poll();
                for (int c : mat[i]) {
                    temp.add(c + poll);
                    if (temp.size() > k) {
                        temp.poll();
                    }
                }
            }
            heap = temp;
        }
        return heap.poll();
    }
}
