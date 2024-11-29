package findMinimumTimeToReachLastRoomI;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomI {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
    }
}
