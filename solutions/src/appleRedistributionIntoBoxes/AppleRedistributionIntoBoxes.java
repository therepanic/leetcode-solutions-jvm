package appleRedistributionIntoBoxes;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int i = apple.length - 1;
        int j = capacity.length - 1;
        while (i >= 0 && j >= 0) {
            if (capacity[j] >= apple[i]) {
                capacity[j] -= apple[i];
                i--;
                if (capacity[j] == 0 && i >= 0) {
                    j--;
                }
            } else {
                apple[i] -= capacity[j];
                j--;
            }
        }
        return capacity.length - j;
    }
}
