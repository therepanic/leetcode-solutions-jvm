package singleThreadedCPU;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskWithIds = new int[n][3];
        for (int i = 0; i < n; i++) {
            taskWithIds[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(taskWithIds, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[2], p2[2]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int[] answer = new int[n];
        int it = 0;
        int time = 0;
        int index = 0;
        while (it < n) {
            while (index < n && taskWithIds[index][0] <= time) {
                heap.add(taskWithIds[index]);
                index++;
            }
            if (!heap.isEmpty()) {
                int[] poll = heap.poll();
                answer[it++] = poll[2];
                time += poll[1];
            } else {
                if (index < n) {
                    time = Math.max(time, taskWithIds[index][0]);
                }
            }
        }
        return answer;
    }

}
