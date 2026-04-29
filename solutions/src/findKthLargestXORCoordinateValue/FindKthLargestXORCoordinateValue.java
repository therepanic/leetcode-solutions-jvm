package findKthLargestXORCoordinateValue;

import java.util.PriorityQueue;

public class FindKthLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] pref = new int[matrix.length + 1][matrix[0].length + 1];
        PriorityQueue<Integer> all = new PriorityQueue<>();
        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                pref[i][j] = (pref[i-1][j]
                        ^ pref[i][j - 1]
                        ^ pref[i - 1][j - 1]
                        ^ matrix[i - 1][j - 1]);
                all.add(pref[i][j]);
                if (all.size() > k) {
                    all.poll();
                }
            }
        }
        return all.poll();
    }
}
