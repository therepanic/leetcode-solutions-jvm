package getWatchedVideosByYourFriends;

import java.util.*;

public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < friends.length; i++) {
            for (int friend : friends[i]) {
                graph.get(i).add(friend);
            }
        }
        Map<String, Integer> freqMap = new HashMap<>();
        Queue<Integer> bfs = new ArrayDeque<>(List.of(id));
        int curLevel = 0;
        boolean[] checked = new boolean[friends.length];
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int poll = bfs.poll();
                if (checked[poll]) continue;
                checked[poll] = true;
                if (curLevel == level) {
                    for (String video : watchedVideos.get(poll)) {
                        freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
                    }
                }
                for (int friend : friends[poll]) {
                    bfs.add(friend);
                }
            }
            curLevel++;
        }
        List<Map.Entry<String, Integer>> freqMapList = new ArrayList<>(freqMap.entrySet());
        freqMapList.sort((p1, p2) -> {
            if (p1.getValue().equals(p2.getValue())) {
                return p1.getKey().compareTo(p2.getKey());
            } else {
                return p1.getValue().compareTo(p2.getValue());
            }
        });
        List<String> answer = new ArrayList<>();
        for (var entry : freqMapList) {
            answer.add(entry.getKey());
        }
        return answer;
    }
}
