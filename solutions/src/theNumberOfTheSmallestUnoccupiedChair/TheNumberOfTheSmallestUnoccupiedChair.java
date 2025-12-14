package theNumberOfTheSmallestUnoccupiedChair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] newTimes = new int[times.length][3];
        for (int i = 0; i < times.length; i++) {
            newTimes[i][0] = times[i][0];
            newTimes[i][1] = times[i][1];
            newTimes[i][2] = i;
        }
        Arrays.sort(newTimes, Comparator.comparingInt(p -> p[0]));
        PriorityQueue<int[]> occupied = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        int nextChair = 0;
        for (int i = 0; i < newTimes.length; i++) {
            while (!occupied.isEmpty() && occupied.peek()[0] <= newTimes[i][0]) {
                free.add(occupied.poll()[1]);
            }
            int chair;
            if (!free.isEmpty()) {
                chair = free.poll();
            } else {
                chair = nextChair++;
            }
            if (newTimes[i][2] == targetFriend) {
                return chair;
            }
            occupied.add(new int[] {newTimes[i][1], chair});
        }
        return -1;
    }
}
