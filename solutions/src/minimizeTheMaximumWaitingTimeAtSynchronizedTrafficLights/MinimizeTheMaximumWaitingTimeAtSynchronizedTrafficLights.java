package minimizeTheMaximumWaitingTimeAtSynchronizedTrafficLights;

public class MinimizeTheMaximumWaitingTimeAtSynchronizedTrafficLights {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max = 0;
        for (int v : lights) {
            max = Math.max(max, v);
        }
        int ans = 0;
        for (int i = 0; i < arrivalTime.length; i++) {
            int v = arrivalTime[i] % period;
            if (v >= max) {
                ans = Math.max(ans, period - v);
            }
        }
        return ans;
    }
}
