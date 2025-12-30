package magicSquaresInGrid;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            loop1: for (int j = 0; j < grid[i].length; j++) {
                if (i + 3 > grid.length || j + 3 > grid[i].length) {
                    continue;
                }
                Set<Integer> sums = new HashSet<>();
                Set<Integer> values = new HashSet<>();

                for (int x = i; x < i + 3; x++) {
                    int sum = 0;
                    for (int y = j; y < j + 3; y++) {
                        if (grid[x][y] < 1 || grid[x][y] > 9) continue loop1;
                        if (values.contains(grid[x][y])) {
                            continue loop1;
                        }
                        values.add(grid[x][y]);
                        sum += grid[x][y];
                    }
                    sums.add(sum);
                    if (sums.size() > 1) {
                        continue loop1;
                    }
                }
                for (int y = j; y < j + 3; y++) {
                    int sum = 0;
                    for (int x = i; x < i + 3; x++) {
                        sum += grid[x][y];
                    }
                    sums.add(sum);
                    if (sums.size() > 1) {
                        continue loop1;
                    }
                }
                int sum = 0;
                for (int x = i, y = j; x < i + 3 && y < j + 3; x++,y++) {
                    sum += grid[x][y];
                }
                sums.add(sum);
                if (sums.size() > 1) {
                    continue loop1;
                }
                sum = 0;
                for (int x = i, y = j + 2; x < i + 3 && y >= j; x++,y--) {
                    sum += grid[x][y];
                }
                sums.add(sum);
                if (sums.size() > 1) {
                    continue loop1;
                }
                count++;
            }
        }
        return count;
    }
}
