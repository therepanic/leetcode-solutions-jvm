package maximumTotalImportanceOfRoads;

import java.util.*;

public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        int[] withoutEdges = new int[n];

        for (int[] road : roads) {
            withoutEdges[road[0]]++;
            withoutEdges[road[1]]++;
        }

        Arrays.sort(withoutEdges);

        long maximumImportance = 0;

        for (int i = withoutEdges.length - 1; i >= 0; i--) {
            maximumImportance += (long) withoutEdges[i] * n;

            n--;
        }

        return maximumImportance;
    }
}
