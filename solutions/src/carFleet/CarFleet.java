package carFleet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> positionMap = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            positionMap.put(position[i], i);
        }

        Arrays.sort(position);

        double leaderTime = Integer.MIN_VALUE;

        int fleetCount = 0;

        for (int i = position.length - 1; i >= 0; i--) {
            double t = (double) (target - position[i]) / speed[positionMap.get(position[i])];

            if (t > leaderTime) {
                fleetCount++;
                leaderTime = t;
            }
        }

        return fleetCount;
    }
}
