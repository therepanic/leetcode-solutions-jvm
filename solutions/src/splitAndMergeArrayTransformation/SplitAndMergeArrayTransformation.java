package splitAndMergeArrayTransformation;

import java.util.*;

public class SplitAndMergeArrayTransformation {

    public List<List<Integer>> variety(List<Integer> nums) {
        List<List<Integer>> generations = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                List<Integer> numsCopy = new ArrayList<>(nums);
                List<Integer> sub = new ArrayList<>(numsCopy.subList(i, j + 1));
                numsCopy.subList(i, j + 1).clear();
                for (int k = 0; k <= numsCopy.size(); k++) {
                    List<Integer> numsCopy2 = new ArrayList<>(numsCopy);
                    numsCopy2.addAll(k, sub);
                    generations.add(numsCopy2);
                }
            }
        }
        return generations;
    }

    public int minSplitMerge(int[] nums1, int[] nums2) {
        Queue<Pair<List<Integer>, Integer>> bfs = new ArrayDeque<>();
        List<Integer> nums = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            nums.add(nums1[i]);
        }
        bfs.add(new Pair<>(nums, 0));
        Set<List<Integer>> visited = new HashSet<>();
        visited.add(nums);
        while (!bfs.isEmpty()) {
            int sz = bfs.size();
            for (int i = 0; i < sz; i++) {
                var poll = bfs.poll();
                List<Integer> entry = poll.first;
                boolean ok = true;
                for (int j = 0; j < entry.size(); j++) {
                    if (nums2[j] != entry.get(j)) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    List<List<Integer>> all = variety(poll.first);
                    for (var e : all) {
                        if (visited.add(e)) {
                            bfs.add(new Pair<>(e, poll.second + 1));
                        }
                    }
                } else {
                    return poll.second;
                }
            }
        }
        return -1;
    }

    static class Pair<T, V> {
        public T first;
        public V second;

        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
