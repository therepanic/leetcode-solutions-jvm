package stockPriceFluctuation;

import java.util.*;

public class StockPrice {

    static class Tuple <T, L> {

        public Tuple(T first, L second) {
            this.first = first;
            this.second = second;
        }

        T first;
        L second;

    }

    private int lastTime;
    private int lastTimePrice;
    private final PriorityQueue<Tuple<Integer, Integer>> maxHeap;
    private final PriorityQueue<Tuple<Integer, Integer>> minHeap;
    private final Map<Integer, Integer> lastAdded;

    public StockPrice() {
        this.lastAdded = new HashMap<>();
        this.maxHeap = new PriorityQueue<>((p1, p2) -> p2.first - p1.first);
        this.minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.first));
    }

    public void update(int timestamp, int price) {
        if (timestamp >= lastTime) {
            lastTime = timestamp;
            lastTimePrice = price;
        }
        lastAdded.put(timestamp, price);
        maxHeap.add(new Tuple<>(price, timestamp));
        minHeap.add(new Tuple<>(price, timestamp));
    }

    public int current() {
        return lastTimePrice;
    }

    public int maximum() {
        while (!maxHeap.isEmpty()) {
            var tuple = maxHeap.peek();
            if (!lastAdded.get(tuple.second).equals(tuple.first)) {
                maxHeap.poll();
                continue;
            }
            return tuple.first;
        }
        return -1;
    }

    public int minimum() {
        while (!minHeap.isEmpty()) {
            var tuple = minHeap.peek();
            if (!lastAdded.get(tuple.second).equals(tuple.first)) {
                minHeap.poll();
                continue;
            }
            return tuple.first;
        }
        return -1;
    }

}
