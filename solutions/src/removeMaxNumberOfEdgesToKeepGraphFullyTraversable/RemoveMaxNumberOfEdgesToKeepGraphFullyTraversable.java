package removeMaxNumberOfEdgesToKeepGraphFullyTraversable;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            edges[i][1]--;
            edges[i][2]--;
            if (edges[i][0] == 3) {
                if (alice.find(edges[i][1]) == alice.find(edges[i][2]) && bob.find(edges[i][1]) == bob.find(edges[i][2])) {
                    count++;
                } else {
                    alice.union(edges[i][1], edges[i][2]);
                    bob.union(edges[i][1], edges[i][2]);
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 1) {
                if (alice.find(edges[i][1]) == alice.find(edges[i][2])) {
                    count++;
                } else {
                    alice.union(edges[i][1], edges[i][2]);
                }
            } else if (edges[i][0] == 2) {
                if (bob.find(edges[i][1]) == bob.find(edges[i][2])) {
                    count++;
                } else {
                    bob.union(edges[i][1], edges[i][2]);
                }
            }
        }
        if (alice.getSize(0) != n || bob.getSize(0) != n) {
            return -1;
        }
        return count;
    }

    static class DSU {
        private int[] parent;
        private int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
            return true;
        }

        public int getSize(int i) {
            return size[find(i)];
        }
    }
}
