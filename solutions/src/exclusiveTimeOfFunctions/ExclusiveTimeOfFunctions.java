package exclusiveTimeOfFunctions;

import java.util.*;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Log> logStack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.start) {
                logStack.addLast(log);
            } else {
                Log poll = logStack.pollLast();
                ans[log.id] += log.time - poll.time + 1;
                if (!logStack.isEmpty()) {
                    ans[logStack.peekLast().id] -= log.time - poll.time + 1;
                }
            }
        }
        return ans;
    }

    public static class Log {
        int id;
        boolean start;
        int time;

        public Log(String content) {
            String[] split = content.split(":");
            this.id = Integer.parseInt(split[0]);
            this.start = split[1].equals("start");
            this.time = Integer.parseInt(split[2]);
        }
    }
}
