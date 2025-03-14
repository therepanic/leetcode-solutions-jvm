package minimumTimeToCompleteTrips;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        int max = Integer.MIN_VALUE;
        for (int t : time) {
            max = Math.max(max, t);
        }
        long l = 1;
        long r = (long) max * totalTrips;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long trips = 0;
            for (int t : time) {
                trips += mid / t;
                if (trips >= totalTrips) break;
            }
            if (trips >= totalTrips) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
