package findRootOfAColoredTree;

public class FindRootOfAColoredTree {
    public int findColoredRoot(int[][] edges, String colors) {
        char[] cls = colors.toCharArray();
        int[] in = new int[edges.length + 1];
        int[] out = new int[edges.length + 1];
        for (int[] edge : edges) {
            char a = cls[edge[0]];
            char b = cls[edge[1]];
            if (a == b) {
                return -1;
            }
            if (a == 'R') {
                if (b == 'W') {
                    in[edge[0]]++;
                    out[edge[1]]++;
                } else if (b == 'B') {
                    in[edge[1]]++;
                    out[edge[0]]++;
                }
            } else if (a == 'W') {
                if (b == 'B') {
                    in[edge[0]]++;
                    out[edge[1]]++;
                } else if (b == 'R') {
                    in[edge[1]]++;
                    out[edge[0]]++;
                }
            } else if (a == 'B') {
                if (b == 'R') {
                    in[edge[0]]++;
                    out[edge[1]]++;
                } else if (b == 'W') {
                    in[edge[1]]++;
                    out[edge[0]]++;
                }
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] > 1) {
                return -1;
            }
            if (out[i] > 2) {
                return -1;
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
