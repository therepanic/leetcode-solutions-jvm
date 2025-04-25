package findMinimumTimeToReachLastRoomI;

import java.util.*;

public class FindMinimumTimeToReachLastRoomI {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        heap.add(new int[] {0, 0, 0});
        int[][] times = new int[moveTime.length][moveTime[0].length];
        for (int[] time : times) {
            Arrays.fill(time, Integer.MAX_VALUE);
        }
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            if (times[poll[0]][poll[1]] <= poll[2]) {
                continue;
            }
            times[poll[0]][poll[1]] = Math.min(times[poll[0]][poll[1]], poll[2]);
            if (poll[0] == moveTime.length - 1 && poll[1] == moveTime[0].length - 1) {
                return poll[2];
            }
            if (poll[0] + 1 < moveTime.length) {
                heap.add(new int[] {poll[0] + 1, poll[1], (poll[2] < moveTime[poll[0] + 1][poll[1]] ? moveTime[poll[0] + 1][poll[1]] + 1 : poll[2] + 1)});
            }
            if (poll[1] + 1 < moveTime[0].length) {
                heap.add(new int[] {poll[0], poll[1] + 1, (poll[2] < moveTime[poll[0]][poll[1] + 1] ? moveTime[poll[0]][poll[1] + 1] + 1 : poll[2] + 1)});
            }
            if (poll[0] - 1 >= 0) {
                heap.add(new int[] {poll[0] - 1, poll[1], (poll[2] < moveTime[poll[0]- 1][poll[1]] ? moveTime[poll[0] - 1][poll[1]] + 1 : poll[2] + 1)});
            }
            if (poll[1] - 1 >= 0) {
                heap.add(new int[] {poll[0], poll[1] - 1, (poll[2] < moveTime[poll[0]][poll[1] - 1] ? moveTime[poll[0]][poll[1] - 1] + 1 : poll[2] + 1)});
            }
        }
        return -1;
    }
}
