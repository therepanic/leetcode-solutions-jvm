package minimumPenaltyForAShop;

import java.util.Arrays;

public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int[] left = new int[customers.length() + 1];
        int[] right = new int[customers.length() + 1];
        char[] customerChars = customers.toCharArray();
        for (int i = left.length - 2; i >= 0; i--) {
            int c = left[i + 1];
            if (i < customerChars.length && customerChars[i] == 'Y') {
                c++;
            }
            left[i] = c;
        }
        for (int i = 1; i < right.length; i++) {
            int c = right[i - 1];
            if (i - 1 < customerChars.length && customerChars[i - 1] == 'N') {
                c++;
            }
            right[i] = c;
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < left.length; i++) {
            int diff = Math.abs(left[i] + right[i]);
            if (diff < min) {
                index = i;
                min = diff;
            }
        }
        return index;
    }
}
