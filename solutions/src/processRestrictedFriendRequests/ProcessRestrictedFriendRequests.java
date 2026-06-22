package processRestrictedFriendRequests;

public class ProcessRestrictedFriendRequests {

    static class DSU {
        private final int[] parent;
        private final int[] size;
        private int numComponents;

        public DSU(DSU other) {
            this.parent = other.parent.clone();
            this.size = other.size.clone();
            this.numComponents = other.numComponents;
        }

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            numComponents = n;
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

            numComponents--;
            return true;
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public int getNumComponents() {
            return numComponents;
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            DSU copy = new DSU(dsu);
            copy.union(requests[i][0], requests[i][1]);
            boolean ok = true;
            for (int j = 0; j < restrictions.length; j++) {
                if (copy.isConnected(restrictions[j][0], restrictions[j][1])) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans[i] = true;
                dsu = copy;
            }
        }
        return ans;
    }
}
