package maximizeAmountAfterTwoDaysOfConversions;

import java.util.*;

public class MaximizeAmountAfterTwoDaysOfConversions {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, List<String>> graph1 = new HashMap<>();
        for (List<String> pair : pairs1) {
            graph1.computeIfAbsent(pair.get(0), p -> new ArrayList<>()).add(pair.get(1));
            graph1.computeIfAbsent(pair.get(1), p -> new ArrayList<>()).add(pair.get(0));
        }
        Map<String, List<String>> graph2 = new HashMap<>();
        for (List<String> pair : pairs2) {
            graph2.computeIfAbsent(pair.get(0), p -> new ArrayList<>()).add(pair.get(1));
            graph2.computeIfAbsent(pair.get(1), p -> new ArrayList<>()).add(pair.get(0));
        }
        Map<String, Map<String, Double>> rates1Map = new HashMap<>();
        for (int i = 0; i < pairs1.size(); i++) {
            rates1Map.computeIfAbsent(pairs1.get(i).get(0), p -> new HashMap<>()).put(pairs1.get(i).get(1), rates1[i]);
            rates1Map.computeIfAbsent(pairs1.get(i).get(1), p -> new HashMap<>()).put(pairs1.get(i).get(0), (double) 1 / rates1[i]);
        }
        Map<String, Map<String, Double>> rates2Map = new HashMap<>();
        for (int i = 0; i < pairs2.size(); i++) {
            rates2Map.computeIfAbsent(pairs2.get(i).get(0), p -> new HashMap<>()).put(pairs2.get(i).get(1), rates2[i]);
            rates2Map.computeIfAbsent(pairs2.get(i).get(1), p -> new HashMap<>()).put(pairs2.get(i).get(0), (double) 1 / rates2[i]);
        }
        double[] bestRate = new double[1];
        bestWay1(graph1, graph2, bestRate, rates1Map, rates2Map, initialCurrency, initialCurrency, 1, new HashSet<>());
        return bestRate[0];
    }

    public void bestWay1(Map<String, List<String>> graph1, Map<String, List<String>> graph2, double[] bestRate, Map<String, Map<String, Double>> rates1,
                         Map<String, Map<String, Double>> rates2, String initCurrency, String node, double rate,
                         Set<String> vis) {
        bestWay2(graph2, bestRate, rates2, initCurrency, node, rate, new HashSet<>());
        vis.add(node);
        for (String v : graph1.getOrDefault(node, List.of())) {
            if (vis.contains(v)) {
                continue;
            }
            bestWay1(graph1, graph2, bestRate, rates1, rates2, initCurrency, v, rates1.get(node).get(v) * rate, vis);
        }
        vis.remove(node);
    }

    public void bestWay2(Map<String, List<String>> graph, double[] bestRate, Map<String, Map<String, Double>> rates, String initCurrency, String node, double rate,
                         Set<String> vis) {
        if (initCurrency.equals(node)) {
            bestRate[0] = Math.max(bestRate[0], rate);
        }
        vis.add(node);
        for (String v : graph.getOrDefault(node, List.of())) {
            if (vis.contains(v)) continue;
            if (rates.containsKey(node) && rates.get(node).containsKey(v)) {
                bestWay2(graph, bestRate, rates, initCurrency, v, rates.get(node).get(v) * rate, vis);
            }
        }
        vis.remove(node);
    }
}
