package maximumTastinessOfCandyBasket;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);

        int l = 0;
        int r = price[price.length - 1];

        int answer = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(price, k, mid)) {
                answer = mid;

                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return answer;
    }

    public boolean check(int[] price, int k, int mid) {
        int lastChecked = price[0];
        int count = 1;

        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastChecked >= mid) {
                lastChecked = price[i];

                count++;
            }
            if (count == k) {
                return true;
            }
        }

        return false;
    }
}
