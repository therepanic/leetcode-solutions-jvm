package findAllPossibleRecipesFromGivenSupplies;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> graphDeg = new HashMap<>();
        for  (int i = 0; i < recipes.length; i++) {
            graphDeg.put(recipes[i], ingredients.get(i).size());
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, p -> new ArrayList<>()).add(recipes[i]);
            }
        }
        Queue<String> ingQueue = new ArrayDeque<>(Arrays.asList(supplies));
        while (!ingQueue.isEmpty()) {
            String rec = ingQueue.poll();
            if (!graph.containsKey(rec)) continue;
            for (String edge : graph.get(rec)) {
                graphDeg.put(edge, graphDeg.get(edge) - 1);
                if (graphDeg.get(edge) == 0) {
                    answer.add(edge);
                    ingQueue.add(edge);
                }
            }
        }
        return answer;
    }
}
