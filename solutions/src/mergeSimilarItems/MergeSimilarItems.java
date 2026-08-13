package mergeSimilarItems;

import java.util.*;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var v : items1) {
            map.put(v[0], v[1]);
        }
        for (var v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> ans = new ArrayList<>(map.size());
        for (var entry : map.entrySet()) {
            ans.add(List.of(entry.getKey(), entry.getValue()));
        }
        ans.sort(Comparator.comparingInt(List::getFirst));
        return ans;
    }
}
