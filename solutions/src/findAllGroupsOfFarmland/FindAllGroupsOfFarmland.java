package findAllGroupsOfFarmland;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    public int[][] findFarmland(int[][] land) {
        List<int[]> lastIndexes = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    lastIndexes.add(new int[] {i, j, i, j});

                    helper(i, j, land, lastIndexes.get(index));

                    index++;
                }
            }
        }

        int[][] farmLand = new int[lastIndexes.size()][];

        for (int i = 0; i < lastIndexes.size(); i++) {
            farmLand[i] = lastIndexes.get(i);
        }

        return farmLand;
    }

    public void helper(int n, int m, int[][] land, int[] localFarmland) {
        if (n < 0 || m < 0 || n >= land.length || m >= land[n].length || land[n][m] == 0) {
            return;
        }

        land[n][m] = 0;

        localFarmland[0] = Math.min(localFarmland[0], n);
        localFarmland[1] = Math.min(localFarmland[1], m);

        localFarmland[2] = Math.max(localFarmland[2], n);
        localFarmland[3] = Math.max(localFarmland[3], m);

        helper(n - 1, m, land, localFarmland);
        helper(n, m - 1, land, localFarmland);

        helper(n + 1, m, land, localFarmland);
        helper(n, m + 1, land, localFarmland);
    }
}
