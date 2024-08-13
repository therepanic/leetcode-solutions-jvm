package pathWithMaximumProbability;

import java.util.*;

public class PathWithMaximumProbability {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<int[]>> graph = new ArrayList<>();

        double[] probability = new double[n];
        probability[start_node] = 1;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new int[] {edges[i][1], i});
            graph.get(edges[i][1]).add(new int[] {edges[i][0], i});
        }

        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Double.compare(o2[1], o1[1]));

        for (int[] value : graph.get(start_node)) {
            priorityQueue.add(new double[] {value[0], succProb[value[1]]});
        }

        while (!priorityQueue.isEmpty()) {
            double[] pair = priorityQueue.poll();

            int secondNode = (int) pair[0];
            double prob = pair[1];

            probability[secondNode] = prob;

            if (secondNode == end_node) {
                return probability[end_node];
            }

            for (int[] nodeValue : graph.get(secondNode)) {
                if (prob * succProb[nodeValue[1]] > probability[nodeValue[0]]) {
                    priorityQueue.add(new double[] {nodeValue[0], prob * succProb[nodeValue[1]]});
                }
            }
        }

        //System.out.println(Arrays.toString(probability));

        return probability[end_node];
    }
}
