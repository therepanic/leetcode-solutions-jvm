package taskScheduler;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[1], p1[1]));
        for (var entry : freqMap.entrySet()) {
            heap.add(new int[] {(int) entry.getKey(), entry.getValue()});
        }
        Queue<int[]> polls = new ArrayDeque<>();
        int time = 0;
        while (!heap.isEmpty() || !polls.isEmpty()) {
            while (!polls.isEmpty() && (polls.peek()[2] <= time)) {
                int[] polled = polls.poll();
                heap.add(new int[] {polled[0], polled[1]});
            }
            if (!heap.isEmpty()) {
                int[] poll = heap.poll();
                poll[1]--;
                if (poll[1] > 0) {
                    polls.add(new int[] {poll[0], poll[1], time + n + 1});
                }
            }
            time++;
        }
        return time;
    }

}
