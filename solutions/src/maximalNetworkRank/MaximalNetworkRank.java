package maximalNetworkRank;

import java.util.HashSet;
import java.util.Set;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Set<String> set = new HashSet<>();


        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            set.add(Math.max(road[0], road[1]) + "-" + Math.min(road[0], road[1]));
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prefix = 0;

                if (set.contains(j + "-" + i)) {
                    prefix = -1;
                }

                max = Math.max(max, degree[i] + degree[j] + prefix);
            }
        }

        return max;
    }
}
