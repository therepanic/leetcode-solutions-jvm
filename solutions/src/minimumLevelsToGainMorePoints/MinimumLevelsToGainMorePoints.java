package minimumLevelsToGainMorePoints;

public class MinimumLevelsToGainMorePoints {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] pref = new int[n];
        pref[n - 1] = possible[n - 1] == 1 ? 1 : -1;
        for (int i = n - 2; i >= 0; i--) {
            pref[i] = pref[i + 1] + (possible[i] == 1 ? 1 : -1);
        }
        long count = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            count += possible[i] == 1 ? 1 : -1;
            if (count > pref[i + 1]) return i + 1;
        }
        return -1;
    }
}
