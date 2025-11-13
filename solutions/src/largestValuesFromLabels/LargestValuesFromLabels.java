package largestValuesFromLabels;

import java.util.*;

public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] to = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            to[i] = new int[] {values[i], labels[i]};
        }
        Arrays.sort(to, (p1, p2) -> Integer.compare(p2[0], p1[0]));
        Map<Integer, Integer> inUsed = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < to.length && numWanted != 0; i++) {
            if (inUsed.containsKey(to[i][1]) && inUsed.get(to[i][1]) + 1 > useLimit) {
                continue;
            }
            inUsed.put(to[i][1], inUsed.getOrDefault(to[i][1], 0) + 1);
            sum += to[i][0];
            numWanted--;
        }
        return sum;
    }
}
