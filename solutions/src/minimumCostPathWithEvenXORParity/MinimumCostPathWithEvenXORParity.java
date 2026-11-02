package minimumCostPathWithEvenXORParity;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostPathWithEvenXORParity {
    public int minActivationCost(int[][] edges, int[] values) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[] {e[1], e[2]});
            graph.get(e[1]).add(new int[] {e[0], e[2]});
        }

        int[] a = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int b = 0;
            for (int j = 0; j < 32; j++) {
                if ((values[i] & (1 << j)) != 0) {
                    b++;
                }
            }
            a[i] = b % 2;
        }
        int ans = Integer.MAX_VALUE;
        for (int[] e : edges) {
            if (a[e[0]] == a[e[1]]) {
                ans = Math.min(ans, e[2]);
            }
        }
        for (int v = 0; v < values.length; v++) {
            int min00 = Integer.MAX_VALUE;
            int min01 = Integer.MAX_VALUE;
            int min10 = Integer.MAX_VALUE;
            int min11 = Integer.MAX_VALUE;
            for (int[] e : graph.get(v)) {
                int p = a[e[0]];
                int w = e[1];
                if (p == 0) {
                    if (w < min00) {
                        min01 = min00;
                        min00 = w;
                    } else if (w < min01) {
                        min01 = w;
                    }
                } else {
                    if (w < min10) {
                        min11 = min10;
                        min10 = w;
                    } else if (w < min11) {
                        min11 = w;
                    }
                }
            }
            if (a[v] == 0) {
                if (min01 != Integer.MAX_VALUE) {
                    ans = Math.min(ans, min00 + min01);
                }
                if (min11 != Integer.MAX_VALUE) {
                    ans = Math.min(ans, min10 + min11);
                }
            } else {
                if (min00 != Integer.MAX_VALUE && min10 != Integer.MAX_VALUE) {
                    ans = Math.min(ans, min00 + min10);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
