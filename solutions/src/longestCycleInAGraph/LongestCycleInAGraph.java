package longestCycleInAGraph;

import java.util.Arrays;

public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        boolean[] checked = new boolean[edges.length];
        int[] answer = new int[] {-1};
        int[] lenArr = new int[edges.length];
        Arrays.fill(lenArr, -1);
        for (int i = 0; i < edges.length; i++) {
            if (lenArr[i] == -1) {
                bypass(edges, i, answer, lenArr, 0, checked);
            }
        }
        return answer[0];
    }

    public void bypass(int[] edges, int node, int[] max, int[] lenArr, int len, boolean[] checked) {
        lenArr[node] = len;
        checked[node] = true;
        if (edges[node] != -1) {
            if (lenArr[edges[node]] == -1) {
                bypass(edges, edges[node], max, lenArr, len + 1, checked);
            } else if (checked[edges[node]]) {
                max[0] = Math.max(max[0], len - lenArr[edges[node]] + 1);
            }
        }
        checked[node] = false;
    }
}
