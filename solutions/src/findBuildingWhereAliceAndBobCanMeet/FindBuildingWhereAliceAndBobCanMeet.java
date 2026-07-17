package findBuildingWhereAliceAndBobCanMeet;

import java.util.*;

public class FindBuildingWhereAliceAndBobCanMeet {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[][] handled = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            handled[i][0] = i;
            handled[i][1] = Math.max(queries[i][0], queries[i][1]);
        }
        Arrays.sort(handled, Comparator.comparingInt(p -> p[1]));
        int it = handled.length - 1;
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (it >= 0 && handled[it][1] == i) {
                int x = queries[handled[it][0]][0];
                int y = queries[handled[it][0]][1];
                int a = Math.min(x, y);
                int b = Math.max(x, y);
                if (a == b || heights[a] < heights[b]) {
                    ans[handled[it][0]] = b;
                } else {
                    int left = 0;
                    int right = stack.size() - 1;
                    while (left <= right) {
                        int mid = right - (left + right) / 2;
                        if (heights[stack.get(mid)] > heights[a]) {
                            ans[handled[it][0]] = stack.get(mid);
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
                it--;
            }
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            stack.add(i);
        }
        return ans;
    }
}
