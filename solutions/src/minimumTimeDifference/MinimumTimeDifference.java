package minimumTimeDifference;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split("\\:");
            times[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(times);
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            minDif = Math.min(minDif, times[i] - times[i - 1]);
        }
        minDif = Math.min(minDif, 1440 - (times[timePoints.size() - 1] - times[0]));
        return minDif;
    }
}
