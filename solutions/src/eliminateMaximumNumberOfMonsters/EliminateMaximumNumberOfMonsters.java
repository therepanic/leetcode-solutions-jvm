package eliminateMaximumNumberOfMonsters;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(time);
        for (int i = 0; i < dist.length; i++) {
            if (time[i] <= i) {
                return i;
            }
        }
        return dist.length;
    }
}
