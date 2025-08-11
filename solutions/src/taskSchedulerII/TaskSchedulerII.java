package taskSchedulerII;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        long curDays = 1;
        Map<Integer, Long> typeMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (typeMap.containsKey(tasks[i])) {
                curDays = Math.max(curDays, typeMap.get(tasks[i]));
            }
            typeMap.put(tasks[i], curDays + space + 1);
            curDays++;
        }
        return curDays - 1;
    }
}
