package maximizeHappinessOfSelectedChildren;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int it = happiness.length - (happiness.length - k - 1) - 2;
        long val = 0;
        for (int i = Math.max(happiness.length - k, 0); i < happiness.length; i++) {
            val += Math.max(happiness[i] - it, 0);
            it--;
        }
        return val;
    }

}
