package miceAndCheese;

import java.util.Arrays;
import java.util.Comparator;

public class MiceAndCheese {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] ids = new Integer[n];
        int all = 0;
        for (int i = 0; i < n; i++) {
            all += reward2[i];
            ids[i] = i;
        }
        Arrays.sort(ids, Comparator.comparingInt(p -> (reward1[(int) p] - reward2[(int) p])).reversed());
        for (int i = 0; i < k; i++) {
            all += reward1[ids[i]] - reward2[ids[i]];
        }
        return all;
    }

}
