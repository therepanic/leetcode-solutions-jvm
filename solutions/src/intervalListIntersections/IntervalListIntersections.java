package intervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                answer.add(new int[] {left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[answer.size()][2];
        for (int it = 0; it < answer.size(); it++) {
            ans[it] = answer.get(it);
        }
        return ans;
    }
}
