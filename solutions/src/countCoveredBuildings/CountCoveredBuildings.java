package countCoveredBuildings;

import java.util.HashMap;
import java.util.Map;

public class CountCoveredBuildings {

    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> xMap = new HashMap<>();
        Map<Integer, int[]> yMap = new HashMap<>();
        for (int[] building : buildings) {
            xMap.compute(building[1], (p1, p2) -> {
               if (p2 == null) {
                   return new int[] {building[0], building[0]};
               } else {
                   p2[0] = Math.min(p2[0], building[0]);
                   p2[1] = Math.max(p2[1], building[0]);
                   return p2;
               }
            });
            yMap.compute(building[0], (p1, p2) -> {
                if (p2 == null) {
                    return new int[] {building[1], building[1]};
                } else {
                    p2[0] = Math.min(p2[0], building[1]);
                    p2[1] = Math.max(p2[1], building[1]);
                    return p2;
                }
            });
        }
        int count = 0;
        for (int[] building : buildings) {
            int[] y = yMap.get(building[0]);
            int[] x = xMap.get(building[1]);;
            if (building[0] > x[0] && building[0] < x[1] && building[1] > y[0] && building[1] < y[1]) {
                count++;
            }
        }
        return count;
    }

}
