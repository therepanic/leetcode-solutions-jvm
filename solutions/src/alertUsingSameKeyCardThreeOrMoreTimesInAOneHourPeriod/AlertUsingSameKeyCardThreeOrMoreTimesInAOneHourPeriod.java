package alertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod;

import java.util.*;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> answer = new ArrayList<>();
        Map<String, List<Integer>> times = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int time = 0;
            for (int j = 0; j < keyTime[i].length(); j++) {
                if (!Character.isDigit(keyTime[i].charAt(j))) {
                    continue;
                }
                time *= 10;
                time += Character.digit(keyTime[i].charAt(j), 10);
            }
            times.computeIfAbsent(keyName[i], p -> new ArrayList<>()).add(time);
        }
        first: for (var entry : times.entrySet()) {
            List<Integer> timeList = entry.getValue();
            Collections.sort(timeList);
            int time = timeList.getFirst();
            int l = 0;
            for (int r = 1; r < timeList.size(); r++) {
                while (timeList.get(r) - time > 100) {
                    l++;
                    time = timeList.get(l);
                }
                if (r - l + 1 >= 3) {
                    answer.add(entry.getKey());
                    continue first;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
