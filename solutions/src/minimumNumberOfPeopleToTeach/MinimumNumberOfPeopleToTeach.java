package minimumNumberOfPeopleToTeach;

import java.util.*;

public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> langs = new ArrayList<>();
        for (int[] langList : languages) {
            List<Integer> list = new ArrayList<>();
            for (int val : langList) {
                list.add(val);
            }
            langs.add(new HashSet<>(list));
        }
        List<int[]> badPairs = new ArrayList<>();
        for (int[] friend : friendships) {
            Set<Integer> intersection = new HashSet<>(langs.get(friend[0] - 1));
            intersection.retainAll(langs.get(friend[1] - 1));
            if (intersection.isEmpty()) {
                badPairs.add(new int[] {friend[0] - 1, friend[1] - 1});
            }
        }
        if (badPairs.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            Set<Integer> teach = new HashSet<>();
            for (int[] pair : badPairs) {
                if (!langs.get(pair[0]).contains(lang)) {
                    teach.add(pair[0]);
                }
                if (!langs.get(pair[1]).contains(lang)) {
                    teach.add(pair[1]);
                }
            }
            min = Math.min(min, teach.size());
        }
        return min;
    }
}
