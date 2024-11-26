package findChampionII;

import java.util.ArrayList;
import java.util.List;

public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        boolean[] graph = new boolean[n];

        for (int[] edge : edges) {
            graph[edge[1]] = true;
        }

        int it = -1;
        boolean have = false;

        for (int i = 0; i < n; i++) {
            if (!graph[i]) {
                if (have) {
                    return -1;
                }
                have = true;
                it = i;
            }
        }

        return it;
    }
}
