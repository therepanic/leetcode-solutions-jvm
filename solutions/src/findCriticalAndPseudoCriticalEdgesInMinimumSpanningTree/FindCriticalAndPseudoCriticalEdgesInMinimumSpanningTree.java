package findCriticalAndPseudoCriticalEdgesInMinimumSpanningTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> newEdges = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            newEdges.add(List.of(edges[i][0], edges[i][1], edges[i][2], i));
        }
        int minMst = findMST(n, new ArrayList<>(newEdges), null);
        if (minMst == Integer.MAX_VALUE) {
            return List.of();
        }
        List<Integer> critical = new ArrayList<>();
        for (int i = 0; i < newEdges.size(); i++) {
            List<Integer> edge = newEdges.get(i);
            newEdges.remove(i);
            if (findMST(n, new ArrayList<>(newEdges), null) > minMst) {
                critical.add(edge.get(3));
            }
            newEdges.add(i, edge);
        }
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < newEdges.size(); i++) {
            List<Integer> edge = newEdges.get(i);
            if (critical.contains(edge.get(3))) {
                continue;
            }
            if (findMST(n, new ArrayList<>(newEdges), edge) == minMst) {
                pseudo.add(edge.get(3));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo);
        return ans;
    }


    public int findMST(int n, List<List<Integer>> edges, List<Integer> forcedEdge) {
        DSU dsu = new DSU(n);
        edges.sort(Comparator.comparingInt(p -> p.get(2)));
        int weight = 0;
        int used = 0;
        if (forcedEdge != null) {
            weight = forcedEdge.get(2);
            dsu.union(forcedEdge.get(0), forcedEdge.get(1));
            used++;
        }
        for (var edge : edges) {
            if (dsu.union(edge.get(0), edge.get(1))) {
                weight += edge.get(2);
                used++;
                if (used == n - 1) {
                    break;
                }
            }
        }
        if (used != n - 1) {
            return Integer.MAX_VALUE;
        }
        return weight;
    }

    public static class DSU {
        private int[] parent;
        private int[] rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI == rootJ) {
                return false;
            }

            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            return true;
        }
    }

}
