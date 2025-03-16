package minimumSpeedToArriveOnTime;

public class MinimumSpeedToArriveOnTime {
    public static int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = (int) 1e7;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            double curHour = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                curHour += Math.ceil((double) dist[i] / mid);
            }
            curHour += (double) dist[dist.length - 1] / mid;
            if (curHour <= hour) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
