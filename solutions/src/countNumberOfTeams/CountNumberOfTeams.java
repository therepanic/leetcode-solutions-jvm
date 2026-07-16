package countNumberOfTeams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int[] sorted = rating.clone();
        Arrays.sort(sorted);
        int id = 0;
        Map<Integer, Integer> compressed = new HashMap<>();
        for (int v : sorted) {
            if (!compressed.containsKey(v)) {
                compressed.put(v, id);
                id++;
            }
        }
        int ans = 0;
        FenwickTree left = new FenwickTree(compressed.size());
        FenwickTree right = new FenwickTree(compressed.size());
        for (int v : rating) {
            right.add(compressed.get(v), 1);
        }
        for (int i = 0; i < rating.length; i++) {
            int rank = compressed.get(rating[i]);
            right.add(rank, -1);
            int leftLess = rank == 0 ? 0 : left.sum(rank - 1);
            int leftGreater = i - left.sum(rank);
            int rightLess = rank == 0 ? 0 : right.sum(rank - 1);
            int rightGreater = rating.length - i - 1 - right.sum(rank);
            ans += leftLess * rightGreater;
            ans += leftGreater * rightLess;
            left.add(rank, 1);
        }
        return ans;
    }

    class FenwickTree {
        private final int[] tree;

        FenwickTree(int n) {
            tree = new int[n + 1];
        }

        void add(int index, int delta) {
            for (index++; index < tree.length; index += index & -index) {
                tree[index] += delta;
            }
        }

        int sum(int index) {
            int result = 0;

            for (index++; index > 0; index -= index & -index) {
                result += tree[index];
            }

            return result;
        }
    }


}
