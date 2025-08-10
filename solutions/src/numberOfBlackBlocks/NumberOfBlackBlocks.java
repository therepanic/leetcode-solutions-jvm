package numberOfBlackBlocks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfBlackBlocks {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Set<List<Integer>> coords = new HashSet<>();
        Set<List<Integer>> banned = new HashSet<>();
        for (int[] cood : coordinates) {
            coords.add(List.of(cood[0], cood[1]));
        }
        long[] ans = new long[5];
        long all = 0;
        for (int[] coord : coordinates) {
            // first case
            if (coord[0] - 1 >= 0 && coord[1] - 1 >= 0 && !banned.contains(List.of(coord[0] - 1, coord[1] - 1))) {
                banned.add(List.of(coord[0] - 1, coord[1] - 1));
                int black = 1;
                if (coords.contains(List.of(coord[0] - 1, coord[1]))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0] - 1, coord[1] - 1))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0], coord[1] - 1))) {
                    black++;
                }
                all++;
                ans[black]++;
            }
            // second case
            if (coord[0] + 1 < m && coord[1] - 1 >= 0 && !banned.contains(List.of(coord[0], coord[1] - 1))) {
                banned.add(List.of(coord[0], coord[1] - 1));
                int black = 1;
                if (coords.contains(List.of(coord[0], coord[1] - 1))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0] + 1, coord[1]))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0] + 1, coord[1] - 1))) {
                    black++;
                }
                all++;
                ans[black]++;
            }
            // third case
            if (coord[0] + 1 < m && coord[1] + 1 < n && !banned.contains(List.of(coord[0], coord[1]))) {
                banned.add(List.of(coord[0], coord[1]));
                int black = 1;
                if (coords.contains(List.of(coord[0] + 1, coord[1] + 1))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0] + 1, coord[1]))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0], coord[1] + 1))) {
                    black++;
                }
                all++;
                ans[black]++;
            }
            // fourth case
            if (coord[0] - 1 >= 0 && coord[1] + 1 < n && !banned.contains(List.of(coord[0] - 1, coord[1]))) {
                banned.add(List.of(coord[0] - 1, coord[1]));
                int black = 1;
                if (coords.contains(List.of(coord[0] - 1, coord[1] + 1))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0] - 1, coord[1]))) {
                    black++;
                }
                if (coords.contains(List.of(coord[0], coord[1] + 1))) {
                    black++;
                }

                all++;
                ans[black]++;
            }
        }
        ans[0] += ((long) (m - 1) * (n - 1)) - all;
        return ans;
    }
}
