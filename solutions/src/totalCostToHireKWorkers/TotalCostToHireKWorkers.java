package totalCostToHireKWorkers;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> left = new PriorityQueue<>((p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        PriorityQueue<int[]> right = new PriorityQueue<>((p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        int limit = candidates * 2 <= n ? candidates : n;
        int l = limit;
        int r = (candidates * 2 <= n) ? n - candidates - 1 : -1;
        for (int i = 0; i < limit; i++) {
            left.add(new int[]{costs[i], i});
        }
        if (candidates * 2 <= n) {
            for (int i = 0; i < candidates; i++) {
                right.add(new int[]{costs[n - i - 1], n - i - 1});
            }
        }
        long sum = 0;
        while (k != 0) {
            if (left.isEmpty() && !right.isEmpty()) {
                sum += right.poll()[0];
            } else if (!left.isEmpty() && right.isEmpty()) {
                sum += left.poll()[0];
            } else if (!left.isEmpty()) {
                int[] leftPeek = left.peek();
                int[] rightPeek = right.peek();
                if (leftPeek[0] < rightPeek[0] || (leftPeek[0] == rightPeek[0] && leftPeek[1] < rightPeek[1])) {
                    sum += left.poll()[0];
                    if (l <= r) {
                        left.add(new int[] {costs[l], l});
                        l++;
                    }
                } else {
                    sum += right.poll()[0];
                    if (r >= l) {
                        right.add(new int[] {costs[r], r});
                        r--;
                    }
                }
            }
            k--;
        }
        return sum;
    }

}
