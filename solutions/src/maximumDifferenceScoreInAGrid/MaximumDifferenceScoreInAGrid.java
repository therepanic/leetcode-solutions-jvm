package maximumDifferenceScoreInAGrid;

import java.util.Arrays;
import java.util.List;

public class MaximumDifferenceScoreInAGrid {
    public int maxScore(List<List<Integer>> grid) {
        int[][] prefix = new int[grid.size()][grid.getFirst().size()];
        for (int[] pref : prefix) {
            Arrays.fill(pref, Integer.MAX_VALUE);
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.getFirst().size(); j++) {
                int val = Math.min(j > 0 ? prefix[i][j - 1] : Integer.MAX_VALUE, i > 0 ? prefix[i - 1][j] : Integer.MAX_VALUE);
                answer = Math.max(answer, grid.get(i).get(j) - val);
                prefix[i][j] = Math.min(val, grid.get(i).get(j));
            }
        }
        return answer;
    }
}
