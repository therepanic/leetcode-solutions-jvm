package topKFrequentWords;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(Map.Entry.<String, Integer> comparingByValue().reversed().thenComparing(Map.Entry::getKey));

        heap.addAll(wordCountMap.entrySet());

        List<String> answer = new ArrayList<>();

        while (k != 0 && !heap.isEmpty()) {
            answer.add(heap.poll().getKey());
            k--;
        }

        return answer;
    }
}
