package mostStonesRemovedWithSameRowOrColumn;

import java.util.*;

public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            rows.computeIfAbsent(stones[i][0], k -> new ArrayList<>()).add(stones[i][1]);
            columns.computeIfAbsent(stones[i][1], k -> new ArrayList<>()).add(stones[i][0]);
        }

        Set<String> checked = new HashSet<>();

        int sum = 0;

        for (int[] stone : stones) {
            String key = stone[0] + "." + stone[1];

            if (!checked.contains(key)) {
                sum += helper(stone[0], stone[1], checked, rows, columns) - 1;
            }
        }

        return sum;
    }

    public int helper(int x, int y, Set<String> checked, Map<Integer, List<Integer>> rows, Map<Integer, List<Integer>> columns) {
        String key = x + "." + y;

        if (checked.contains(key)) {
            return 0;
        }

        checked.add(key);

        int sum = 1;

        for (int newY : rows.get(x)) {
            sum += helper(x, newY, checked, rows, columns);
        }

        for (int newX : columns.get(y)) {
            sum += helper(newX, y, checked, rows, columns);
        }

        return sum;
    }
}
