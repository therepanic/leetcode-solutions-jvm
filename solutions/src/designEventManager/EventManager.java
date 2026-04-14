package designEventManager;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class EventManager {

    private final Map<Integer, Integer> events;

    private final PriorityQueue<int[]> heap;

    public EventManager(int[][] events) {
        this.events = new HashMap<>();
        this.heap = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] != p2[1]) {
                return Integer.compare(p2[1], p1[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        for (int i = 0; i < events.length; i++) {
            updatePriority(events[i][0], events[i][1]);
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        this.events.put(eventId, newPriority);
        this.heap.add(new int[] {eventId, newPriority});
    }

    public int pollHighest() {
        int h = -1;
        while (!this.heap.isEmpty()) {
            int[] k = this.heap.peek();
            if (this.events.getOrDefault(k[0], -1).equals(k[1])) {
                h = k[0];
                this.events.remove(k[0]);
                break;
            }
            this.heap.poll();
        }
        return h;
    }
}
