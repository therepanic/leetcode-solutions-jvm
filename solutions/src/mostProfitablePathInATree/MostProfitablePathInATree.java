package mostProfitablePathInATree;

import java.util.*;

public class MostProfitablePathInATree {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] bobTimings = new int[graph.size()];
        Arrays.fill(bobTimings, -1);
        bypassBobi(graph, bob, 0, bobTimings);
        int[] best = new int[] {Integer.MIN_VALUE};
        bypassAlice(graph, 0, 0, 0, bobTimings, new boolean[graph.size()], amount, best);
        return best[0];
    }

    private static void bypassAlice(List<List<Integer>> graph, int curNode, int pref, int time, int[] bobTimings, boolean[] checked, int[] amount, int[] best) {
        if (checked[curNode]) return;
        checked[curNode] = true;
        if (bobTimings[curNode] == time) {
            pref += amount[curNode] / 2;
        } else if (bobTimings[curNode] == -1 || bobTimings[curNode] > time){
            pref += amount[curNode];
        }
        time++;
        if (curNode != 0 && graph.get(curNode).size() == 1) {
            best[0] = Math.max(best[0], pref);
            return;
        }
        for (int node : graph.get(curNode)) {
            bypassAlice(graph, node, pref, time, bobTimings, checked, amount, best);
        }
    }

    private static boolean bypassBobi(List<List<Integer>> graph, int curNode, int time, int[] bobTimings) {
        if (bobTimings[curNode] != -1) return false;
        bobTimings[curNode] = time;
        if (curNode == 0) return true;
        boolean ok = false;
        for (int node : graph.get(curNode)) {
            if (bypassBobi(graph, node, time + 1, bobTimings)) {
                ok = true;
            }
        }
        if (!ok) bobTimings[curNode] = -1;
        return ok;
    }
}
