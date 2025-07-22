package maximumBagsWithFullCapacityOfRocks;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] difs = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            difs[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(difs);
        int c = 0;
        for (int i = 0; i < difs.length; i++) {
            if (difs[i] == 0) {
                c++;
            } else {
                if (additionalRocks - difs[i] < 0) {
                    return c;
                }
                c++;
                additionalRocks -= difs[i];
                if (additionalRocks == 0) {
                    return c;
                }
            }
        }
        return c;
    }
}
