package minimumLightsToIlluminateARoad;

public class MinimumLightsToIlluminateARoad {
    public int minLights(int[] lights) {
        boolean[] ready = new boolean[lights.length];
        int readiness = 0;
        for (int i = 0; i < lights.length; i++) {
            if (lights[i] > 0 && lights[i] >= readiness) {
                ready[i] = true;
                readiness = lights[i];
            } else {
                if (readiness > 0) {
                    ready[i] = true;
                    readiness--;
                }
            }
        }
        readiness = 0;
        for (int i = lights.length - 1; i >= 0; i--) {
            if (lights[i] > 0 && lights[i] >= readiness) {
                ready[i] = true;
                readiness = lights[i];
            } else {
                if (readiness > 0) {
                    ready[i] = true;
                    readiness--;
                }
            }
        }
        int ans = 0;
        int streak = 0;
        for (boolean b : ready) {
            if (!b) {
                streak++;
            } else {
                ans += (streak + 2) / 3;
                streak = 0;
            }
        }
        ans += (streak + 2) / 3;
        return ans;
    }
}
