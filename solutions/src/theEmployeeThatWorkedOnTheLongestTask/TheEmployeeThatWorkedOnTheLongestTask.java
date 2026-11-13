package theEmployeeThatWorkedOnTheLongestTask;

import java.util.HashMap;
import java.util.Map;

public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int a = -1;
        int b = 0;
        int c = -1;
        for (int i = 0; i < logs.length; i++) {
            int diff = logs[i][1] - b;
            if (diff >= c) {
                if (diff == c && a > logs[i][0] || diff > c) {
                    c = diff;
                    a = logs[i][0];
                }
            }
            b = logs[i][1];
        }
        return a;
    }
}
