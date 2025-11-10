package numberOfOrdersInTheBacklog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sellHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        PriorityQueue<int[]> buyHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[0], p1[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sellHeap.isEmpty() && order[0] >= sellHeap.peek()[0] && order[1] != 0) {
                    int[] poll = sellHeap.poll();
                    int traded = Math.min(order[1], poll[1]);
                    order[1] -= traded;
                    poll[1] -= traded;
                    if (poll[1] > 0) {
                        sellHeap.add(poll);
                    }
                }
                if (order[1] != 0) {
                    buyHeap.add(order);
                }
            } else {
                while (!buyHeap.isEmpty() && order[0] <= buyHeap.peek()[0] && order[1] != 0) {
                    int[] poll = buyHeap.poll();
                    int traded = Math.min(order[1], poll[1]);
                    order[1] -= traded;
                    poll[1] -= traded;
                    if (poll[1] > 0) {
                        buyHeap.add(poll);
                    }
                }
                if (order[1] != 0) {
                    sellHeap.add(order);
                }
            }
        }
        long c = 0;
        while (!sellHeap.isEmpty()) {
            c += sellHeap.poll()[1];
        }
        while (!buyHeap.isEmpty()) {
            c += buyHeap.poll()[1];
        }
        return (int) (c % (1000000000 + 7));
    }
}
