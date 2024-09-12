package kokoEatingBananas;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = piles[0];

        for (int pile : piles) {
            maxValue = Math.max(maxValue, pile);
        }

        int answer = Integer.MAX_VALUE;

        int l = 1;
        int r = maxValue;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (mid == 0) {
                break;
            }

            long countH = 0;

            for (int pile : piles) {
                int cur = pile / mid;

                if (pile % mid != 0) {
                    cur += 1;
                }

                countH += cur;
            }


            if (countH <= h) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }
}
