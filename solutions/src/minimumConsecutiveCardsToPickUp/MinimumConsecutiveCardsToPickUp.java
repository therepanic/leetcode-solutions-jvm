package minimumConsecutiveCardsToPickUp;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < cards.length; r++) {
            numCount.put(cards[r], numCount.getOrDefault(cards[r], 0) + 1);
            while (numCount.get(cards[r]) > 1) {
                ans = Math.min(r - l + 1, ans);
                numCount.put(cards[l], numCount.get(cards[l]) - 1);
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
