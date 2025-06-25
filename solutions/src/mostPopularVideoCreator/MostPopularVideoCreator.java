package mostPopularVideoCreator;

import java.util.*;

public class MostPopularVideoCreator {

     static class Tuple<T, K> {

        public Tuple(T first, K second) {
            this.first = first;
            this.second = second;
        }

        T first;
        K second;
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = views.length;
        Map<String, Integer> creatorSum = new HashMap<>();
        Map<String, Tuple<String, Integer>> creatorVideo = new HashMap<>();
        int maxVal = 0;
        Set<String> bestCreators = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int val = creatorSum.getOrDefault(creators[i], 0) + views[i];
            if (val > maxVal) {
                bestCreators.clear();
                bestCreators.add(creators[i]);
                maxVal = val;
            } else if (val == maxVal) {
                bestCreators.add(creators[i]);
            }
            creatorSum.put(creators[i], val);
            if (!creatorVideo.containsKey(creators[i]) || creatorVideo.get(creators[i]).second < views[i] ||
                    creatorVideo.get(creators[i]).second == views[i] && creatorVideo.get(creators[i]).first.compareTo(ids[i]) > 0) {
                creatorVideo.put(creators[i], new Tuple<>(ids[i], views[i]));
            }
        }
        List<List<String>> popular = new ArrayList<>();
        for (String creator : bestCreators) {
            popular.add(List.of(creator, creatorVideo.get(creator).first));
        }
        return popular;
    }

}
