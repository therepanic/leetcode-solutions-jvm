package numberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> distanceCountMap = new HashMap<>();

        int c = 0;

        for (int i = 0; i < points.length; i++) {
            int[] pointOne = points[i];

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] pointTwo = points[j];

                int distance = (int) (Math.pow(pointTwo[0] - pointOne[0], 2) + Math.pow(pointTwo[1] - pointOne[1], 2));

                distanceCountMap.put(distance, distanceCountMap.getOrDefault(distance, 0) + 1);
            }

            for (int value : distanceCountMap.values()) {
                c += value * (value - 1);
            }
            distanceCountMap.clear();
        }

        return c;
    }
}
