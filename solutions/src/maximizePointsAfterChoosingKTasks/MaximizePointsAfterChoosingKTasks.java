package maximizePointsAfterChoosingKTasks;

import java.util.Arrays;

public class MaximizePointsAfterChoosingKTasks {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long answer = 0;
        int n = technique1.length;
        int[][] diff = new int[n][2];
        for (int i = 0; i < n; i++) {
            diff[i][0] = technique1[i] - technique2[i];
            diff[i][1] = i;
        }
        Arrays.sort(diff, (p1, p2) -> Integer.compare(p2[0], p1[0]));
        boolean[] take = new boolean[n];
        for (int i = 0; i < k; i++) {
            take[diff[i][1]] = true;
        }
        for (int i = 0; i < n; i++) {
            if (take[i]) {
                answer += technique1[i];
            } else {
                answer += Math.max(technique1[i], technique2[i]);
            }
        }
        return answer;
    }
}
