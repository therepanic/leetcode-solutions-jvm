package minimumCostToConvertStringI;

import java.util.*;

public class MinimumCostToConvertStringI {

    static class Tuple<T, L> {

        public Tuple(T first, L second) {
            this.first = first;
            this.second = second;
        }

        T first;
        L second;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        int m = source.length();
        Map<Character, List<Tuple<Character, Long>>> convertCost = new HashMap<>();
        for (int i = 0; i < n; i++) {
            convertCost.computeIfAbsent(original[i], p -> new ArrayList<>()).add(new Tuple<>(changed[i], (long) cost[i]));
        }
        PriorityQueue<Tuple<Character, Long>> heap = new PriorityQueue<>(Comparator.comparingLong(p -> p.second));
        Map<Character, Map<Character, Long>> dpAll = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < m; i++) {
            if (source.charAt(i) == target.charAt(i)) continue;
            if (dpAll.containsKey(source.charAt(i))) {
                Map<Character, Long> dp = dpAll.get(source.charAt(i));
                if (!dp.containsKey(target.charAt(i))) {
                    return -1;
                } else {
                    answer += dp.get(target.charAt(i));
                    continue;
                }
            }
            Map<Character, Long> dp = new HashMap<>();
            dpAll.put(source.charAt(i), dp);
            heap.add(new Tuple<>(source.charAt(i), 0L));
            while (!heap.isEmpty()) {
                var poll = heap.poll();
                for (var tuple : convertCost.getOrDefault(poll.first, List.of())) {
                    long sum = tuple.second + poll.second;
                    if (dp.containsKey(tuple.first) && dp.get(tuple.first) <= sum) {
                        continue;
                    }
                    dp.put(tuple.first, sum);
                    heap.add(new Tuple<>(tuple.first, sum));
                }
            }
            if (!dp.containsKey(target.charAt(i))) {
                return -1;
            } else {
                answer += dp.get(target.charAt(i));
            }
        }
        return answer;
    }

}
