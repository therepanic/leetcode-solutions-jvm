package minimumAdjacentSwapsToAlternateParity;

import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwapsToAlternateParity {

    public static int minSwaps(int[] nums) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens.add(i);
            } else {
                odds.add(i);
            }
        }
        if (Math.abs(evens.size() - odds.size()) > 1) {
            return -1;
        }
        int need = Integer.MAX_VALUE;
        if (evens.size() >= odds.size()) {
            need = Math.min(need, calculateSwaps(evens, 0));
        }
        if (odds.size() >= evens.size()) {
            need = Math.min(need, calculateSwaps(evens, 1));
        }
        return need == Integer.MAX_VALUE ? 0 : need;
    }

    private static int calculateSwaps(List<Integer> indices, int startIndex) {
        int swaps = 0;
        for (int i = 0; i < indices.size(); i++) {
            int currentIndex = indices.get(i);
            int targetIndex = startIndex + 2 * i;
            swaps += Math.abs(currentIndex - targetIndex);
        }
        return swaps;
    }

}
