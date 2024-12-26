package seatReservationManager;

import java.util.PriorityQueue;

public class SeatManager {
    private final PriorityQueue<Integer> heap;
    public SeatManager(int n) {
        this.heap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            heap.add(i);
        }
    }

    public int reserve() {
        return heap.poll();
    }

    public void unreserve(int seatNumber) {
        if (!heap.isEmpty() && heap.peek() == seatNumber) return;
        heap.add(seatNumber);
    }
}
