package maximumNumberOfEventsThatCanBeAttended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(p -> p[0]));
        PriorityQueue<Integer> eventHeap = new PriorityQueue<>();
        int maxDay = 0;
        for (int i = 0; i < events.length; i++) {
            maxDay = Math.max(events[i][1], maxDay);
        }
        int maxEvents = 0;
        for (int day = 1, j = 0; day <= maxDay; day++) {
            while (j < events.length && events[j][0] == day) {
                eventHeap.add(events[j][1]);
                j++;
            }
            while (!eventHeap.isEmpty() && eventHeap.peek() < day) {
                eventHeap.poll();
            }
            if (!eventHeap.isEmpty()) {
                maxEvents++;
                eventHeap.poll();
            }
        }
        return maxEvents;
    }

}
