package nodeWithHighestEdgeScore;

public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        long[] nodes = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i]] += i;
        }
        long maxVal = 0;
        int maxNode = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] > maxVal) {
                maxVal = nodes[i];
                maxNode = i;
            }
        }
        return maxNode;
    }
}
