package pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][][] pacific = new int[heights.length][heights[0].length][2];
        int[][][] atlantic = new int[heights.length][heights[0].length][2];

        Boolean[][] pacificChecked = new Boolean[heights.length][heights[0].length];
        Boolean[][] atlanticChecked = new Boolean[heights.length][heights[0].length];

        int[][] viewedPath = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificChecked[i][j] == null) {
                    helper(i, j, heights, pacificChecked, pacific, heights[i][j], true, viewedPath);
                }

                if (atlanticChecked[i][j] == null) {
                    helper(i, j, heights, atlanticChecked, atlantic, heights[i][j], false, viewedPath);
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificChecked[i][j] != null && atlanticChecked[i][j] != null) {
                    answer.add(new ArrayList<>(List.of(pacific[i][j][0], pacific[i][j][1])));
                }
            }
        }

        return answer;
    }

    public static boolean helper(int n, int m, int[][] heights, Boolean[][] checked, int[][][] answer, int lastHeight, boolean isPacific, int[][] viewedPath) {
        if (n < 0 || m < 0 || n >= heights.length || m >= heights[n].length || heights[n][m] > lastHeight || viewedPath[n][m] == 1) {
            return false;
        }

        if (checked[n][m] != null) {
            return checked[n][m];
        }

        int currentHeight = heights[n][m];

        viewedPath[n][m] = 1;

        if (isPacific) {
            if (n - 1 < 0 || m - 1 < 0) {
                checked[n][m] = true;

                answer[n][m][0] = n;
                answer[n][m][1] = m;

                viewedPath[n][m] = 0;
                return true;
            }
        } else {
            if (n + 1 == heights.length || m + 1 == heights[n].length) {
                checked[n][m] = true;

                answer[n][m][0] = n;
                answer[n][m][1] = m;

                viewedPath[n][m] = 0;
                return true;
            }
        }

        boolean left = helper(n, m - 1, heights, checked, answer, currentHeight, isPacific, viewedPath);
        boolean right = helper(n, m + 1, heights, checked, answer, currentHeight, isPacific, viewedPath);
        boolean down = helper(n - 1, m, heights, checked, answer, currentHeight, isPacific, viewedPath);
        boolean up = helper(n + 1, m, heights, checked, answer, currentHeight, isPacific, viewedPath);

        if (left || right || down || up) {
            checked[n][m] = true;

            answer[n][m][0] = n;
            answer[n][m][1] = m;
        }

        viewedPath[n][m] = 0;

        return left || right || down || up;
    }
}
