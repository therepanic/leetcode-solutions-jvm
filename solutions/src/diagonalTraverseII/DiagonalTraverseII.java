package diagonalTraverseII;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> buckets = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int d = i + j;
                while (d >= buckets.size()) {
                    buckets.add(new ArrayList<>());
                }
                buckets.get(d).add(row.get(j));
                total++;
            }
        }
        int[] ans = new int[total];
        int idx = 0;
        for (List<Integer> b : buckets) {
            for (int k = b.size() - 1; k >= 0; k--) {
                ans[idx++] = b.get(k);
            }
        }
        return ans;
    }
}
