package queryKthSmallestTrimmedNumber;

import java.util.*;

public class QueryKthSmallestTrimmedNumber {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer, List<int[]>> trim = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            trim.computeIfAbsent(query[1], p -> new ArrayList<>()).add(new int[] {query[0], i});
        }
        int[] ans = new int[queries.length];
        for (var entry : trim.entrySet()) {
            int trimTo = entry.getKey();
            int kMax = 0;
            for (int[] v : entry.getValue()) {
                kMax = Math.max(v[0], kMax);
            }
            PriorityQueue<Node> heap = new PriorityQueue<>((p1, p2) -> {
                if (p1.key.equals(p2.key)) {
                    return Integer.compare(p2.idx, p1.idx);
                } else {
                    return p2.key.compareTo(p1.key);
                }
            });
            for (int i = 0; i < nums.length; i++) {
                String num = nums[i];
                heap.add(new Node (num.substring(num.length() - trimTo), i));
                if (heap.size() > kMax) {
                    heap.poll();
                }
            }
            int[] ks = new int[heap.size()];
            for (int i = ks.length - 1; i >= 0 && !heap.isEmpty(); i--) {
                ks[i] = heap.poll().idx;
            }
            for (int[] query : entry.getValue()) {
                ans[query[1]] = ks[query[0] - 1];
            }
        }
        return ans;
    }

    static class Node { String key; int idx;

        public Node(String key, int idx) {
            this.key = key;
            this.idx = idx;
        }
    }
}
