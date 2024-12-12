package successfulPairsOfSpellsAndPotions;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] nums = new int[spells.length];
        int it = 0;

        Arrays.sort(potions);

        for (int spell : spells) {
            int l = 0;
            int r = potions.length - 1;

            int count = 0;
            while (l <= r) {
                int mid = (r + l) / 2;

                if ((long) spell * potions[mid] >= success) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

                count = mid;
            }

            if ((long) spell * potions[count] >= success) {
                nums[it] = potions.length - count;
            } else if (count + 1 < potions.length && (long) spell * potions[count + 1] >= success) {
                nums[it] = potions.length - count - 1;
            }

            it++;
        }


        return nums;
    }
}
