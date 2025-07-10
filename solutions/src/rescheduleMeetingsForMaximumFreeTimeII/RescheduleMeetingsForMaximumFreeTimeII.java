package rescheduleMeetingsForMaximumFreeTimeII;

public class RescheduleMeetingsForMaximumFreeTimeII {

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length + 1];
        for (int i = 1; i < startTime.length; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[0] = startTime[0];
        gaps[startTime.length] = eventTime - endTime[startTime.length - 1];
        int[] maxLeft = new int[startTime.length + 1];
        int[] maxRight = new int[startTime.length + 1];
        maxLeft[0] = gaps[0];
        maxRight[startTime.length] = gaps[startTime.length];
        for (int i = 1; i <= startTime.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }
        for (int i = startTime.length - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            int dur = endTime[i] - startTime[i];
            int adj = gaps[i] + gaps[i + 1];

            int left = (i > 0 ? maxLeft[i - 1] : 0);
            int right = (i + 2 <= startTime.length ? maxRight[i + 2] : 0);

            int preAns = adj + (dur <= Math.max(left, right) ? dur : 0);
            ans = Math.max(ans, preAns);
        }
        return ans;
    }

}
