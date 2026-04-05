package largestCombinationWithBitwiseANDGreaterThanZero;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {
        int[] ones = new int[32];
        for (int i = 0; i < candidates.length; i++) {
            int value = candidates[i];
            for (int j = 31; j >= 0; j--) {
                int bit = (value >> j) & 1;
                if (bit == 1) {
                    ones[j]++;
                }
            }
        }
        int most = -1;
        for (int i = 0; i < 32; i++) {
            most = Math.max(most, ones[i]);
        }
        return most;
    }
}
