package maximumUnitsOnATruck;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(p -> p[1]));
        int units = 0;
        for (int i = boxTypes.length - 1; i >= 0 && truckSize != 0; i--) {
            int a = Math.min(truckSize, boxTypes[i][0]);
            units += a * boxTypes[i][1];
            truckSize -= a;
        }
        return units;
    }
}
