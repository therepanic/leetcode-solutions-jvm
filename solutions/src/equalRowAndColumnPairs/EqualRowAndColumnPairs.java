package equalRowAndColumnPairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> gridMap = new HashMap<>();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]).append("-");

            }

            String sbString = sb.toString();

            gridMap.put(sbString, gridMap.getOrDefault(sbString, 0) + 1);
            sb.setLength(0);
        }

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]).append("-");
            }

            if (gridMap.containsKey(sb.toString())) {
                count += gridMap.get(sb.toString());
            }

            sb.setLength(0);
        }

        return count;
    }
}
