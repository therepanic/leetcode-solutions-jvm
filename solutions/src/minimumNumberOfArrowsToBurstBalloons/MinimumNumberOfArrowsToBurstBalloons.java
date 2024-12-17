package minimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));

        int[] last = null;

        int count = 1;

        for (int[] point : points) {
            if (last == null) {
                last = point;
            } else if (point[0] > last[1]) {
                last = point;
                count++;
            }
        }

        return count;
    }
}
