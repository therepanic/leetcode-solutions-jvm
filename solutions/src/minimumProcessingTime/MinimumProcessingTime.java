package minimumProcessingTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {
    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);

        int processorTimePointer = processorTime.size() - 1;

        int maxTime = -1;

        for (int i = 0; i < tasks.size(); i++) {
            maxTime = Math.max(maxTime, tasks.get(i) + processorTime.get(processorTimePointer));

            if (i >= 3 && (i + 1) % 4 == 0) {
                processorTimePointer--;
            }
        }

        return maxTime;
    }
}
