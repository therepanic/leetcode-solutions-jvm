package numberOfProvinces;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        Set<Integer> checked = new HashSet<>();
        int provincesCount = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!checked.contains(i)) {
                helper(i, isConnected, checked);

                provincesCount++;
            }
        }

        return provincesCount;
    }

    public static void helper(int m, int[][] isConnected, Set<Integer> checked) {
        checked.add(m);

        for (int i = 0; i < isConnected.length; i++) {
            if (i == m) {
                continue;
            }

            if (isConnected[m][i] == 1 && !checked.contains(i)) {
                helper(i, isConnected, checked);
            }
        }
    }
}
