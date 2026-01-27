package numberOfWaysToAssignEdgeWeightsI;

import java.util.*;

public class NumberOfWaysToAssignEdgeWeightsI {
    public int assignEdgeWeights(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], p -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], p -> new ArrayList<>()).add(edge[0]);
        }
        int[] maxLen = new int[1];
        bypass(1, graph, new HashSet<>(), maxLen, 0);
        return (int) (modPow(2L, maxLen[0] - 1, 1000000007) % 1000000007);
    }

    public void bypass(int node, Map<Integer, List<Integer>> graph, Set<Integer> checked, int[] max, int c) {
        if (checked.contains(node)) return;
        max[0] = Math.max(max[0], c);
        checked.add(node);
        for (int v : graph.getOrDefault(node, List.of())) {
            bypass(v, graph, checked, max, c + 1);
        }
        checked.remove(node);
    }

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
