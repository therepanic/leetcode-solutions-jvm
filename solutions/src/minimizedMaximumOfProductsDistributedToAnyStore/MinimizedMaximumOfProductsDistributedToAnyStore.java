package minimizedMaximumOfProductsDistributedToAnyStore;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 0;
        for (int quantity : quantities) {
            r = Math.max(quantity, r);
        }
        int answer = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m = n;
            for (int quantity : quantities) {
                m -= (quantity + mid - 1) / mid;
            }
            if (m >= 0) {
                r = mid - 1;
                answer = Math.min(mid, answer);
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }
}
