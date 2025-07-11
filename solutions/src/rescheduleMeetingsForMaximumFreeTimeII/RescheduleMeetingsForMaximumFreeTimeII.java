package rescheduleMeetingsForMaximumFreeTimeII;

public class RescheduleMeetingsForMaximumFreeTimeII {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n - 1];
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];
        maxLeft[0] = gaps[0];
        maxRight[n] = gaps[n];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int event = endTime[i] - startTime[i];
            int gapsSize = gaps[i] + gaps[i + 1];

            int left = (i > 0 ? maxLeft[i - 1] : 0);
            int right = (i + 2 <= n ? maxRight[i + 2] : 0);

            ans = Math.max(ans, gapsSize + ((Math.max(left, right) >= event) ? event : 0));
        }
        return ans;
    }

}
