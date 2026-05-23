package maximumNumberOfAlloys;

import java.util.List;

public class MaximumNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < composition.size(); i++) {
            int l = 0;
            int r = Integer.MAX_VALUE / 2;
            while (l <= r) {
                long cur = budget;
                int mid = l + (r - l) / 2;
                for (int j = 0; j < n; j++) {
                    long need = (long) composition.get(i).get(j) * mid;
                    long buy = Math.max(0, need - stock.get(j));
                    long price = buy * cost.get(j);
                    cur -= price;
                    if (cur < 0) {
                        r = mid - 1;
                        break;
                    }
                }
                if (cur >= 0) {
                    max = Math.max(max, mid);
                    l = mid + 1;
                }
            }
        }
        return max;
    }
}
