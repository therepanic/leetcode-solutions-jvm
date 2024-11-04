package minimumRoundsToCompleteAllTasks;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskCountMap = new HashMap<>();

        for (int task : tasks) {
            if (taskCountMap.containsKey(task)) {
                taskCountMap.put(task, taskCountMap.get(task) + 1);
            } else {
                taskCountMap.put(task, 1);
            }
        }

        int count = 0;

        for (int value : taskCountMap.values()) {
            if (value == 1) {
                return -1;
            }

            while (value != 0) {
                if (value == 2) {
                    count++;
                    break;
                } else if (value == 4) {
                    count += 2;
                    break;
                }

                value -= 3;
                count++;


            }
        }

        return count;
    }
}
