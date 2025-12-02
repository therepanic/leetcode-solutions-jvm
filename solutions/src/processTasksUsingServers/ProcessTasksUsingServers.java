package processTasksUsingServers;

import java.util.PriorityQueue;

public class ProcessTasksUsingServers {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Integer> availableServers = new PriorityQueue<>((p1, p2) -> {
            if (servers[p1] == servers[p2]) {
                return Integer.compare(p1, p2);
            } else {
                return Integer.compare(servers[p1], servers[p2]);
            }
        });
        for (int i = 0; i < servers.length; i++) {
            availableServers.add(i);
        }
        PriorityQueue<int[]> processingServers = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[0], p2[0]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int[] answer = new int[tasks.length];
        int curTime = 0;
        for (int i = 0; i < tasks.length; i++) {
            curTime = Math.max(curTime, i);
            while (!processingServers.isEmpty() && processingServers.peek()[1] <= curTime) {
                availableServers.add(processingServers.poll()[0]);
            }
            if (availableServers.isEmpty()) {
                int time = processingServers.peek()[1];
                curTime = time;
                while (!processingServers.isEmpty() && time == processingServers.peek()[1]) {
                    availableServers.add(processingServers.poll()[0]);
                }
            }
            while (!processingServers.isEmpty() && processingServers.peek()[1] <= curTime) {
                availableServers.add(processingServers.poll()[0]);
            }
            int serverId = availableServers.poll();
            processingServers.add(new int[] {serverId, tasks[i] + curTime});
            answer[i] = serverId;
        }
        return answer;
    }
}
