package removeStonesToMinimizeTheTotal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pills = new PriorityQueue<>(Comparator.reverseOrder());

        for (int pile : piles) {
            pills.add(pile);
        }

        for (int i = 0; i < k; i++) {
            if (!pills.isEmpty()) {
                pills.add(Math.round((float) pills.poll() / 2));
            }
        }

        int sum = 0;

        while (!pills.isEmpty()) {
            sum += pills.poll();
        }

        return sum;
    }
}
