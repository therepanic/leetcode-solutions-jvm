package countMentionsPerUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountMentionsPerUser {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        List<List<Integer>> usersInOffline = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            usersInOffline.add(new ArrayList<>());
        }
        for (var event : events) {
            if (event.getFirst().equals("OFFLINE")) {
                usersInOffline.get(Integer.parseInt(event.get(2))).add(Integer.parseInt(event.get(1)));
            }
        }
        for (int i = 0; i < numberOfUsers; i++) {
            Collections.sort(usersInOffline.get(i));
        }
        int[] mentions = new int[numberOfUsers];
        for (var event : events) {
            if (event.getFirst().equals("MESSAGE")) {
                if (event.get(2).equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (event.get(2).equals("HERE")) {
                    int timestamp = Integer.parseInt(event.get(1));
                    for (int i = 0; i < numberOfUsers; i++) {
                        int smaller = smallerBound(usersInOffline.get(i), timestamp);
                        if (usersInOffline.get(i).isEmpty() || smaller == -1 || smaller + 60 <= timestamp) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] splitIds = event.get(2).split(" ");
                    for (String strId : splitIds) {
                        int id = Integer.parseInt(strId.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }
        return mentions;
    }

    public int smallerBound(List<Integer> values, int val) {
        int l = 0;
        int r = values.size() - 1;
        int answer = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (values.get(mid) > val) {
                r = mid - 1;
            } else {
                answer = values.get(mid);
                l = mid + 1;
            }
        }
        return answer;
    }

}
