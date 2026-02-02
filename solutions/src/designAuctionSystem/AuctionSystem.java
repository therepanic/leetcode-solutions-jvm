package designAuctionSystem;

import java.util.*;

public class AuctionSystem {

    private static class Tuple<T, V> {
        public T first;
        public V second;

        public Tuple(T first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Tuple<?, ?> tuple)) return false;
            return Objects.equals(first, tuple.first) && Objects.equals(second, tuple.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    private final Map<Tuple<Integer, Integer>, Integer> amounts;

    private final Map<Integer, PriorityQueue<int[]>> higher;

    public AuctionSystem() {
        this.amounts = new HashMap<>();
        this.higher = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        this.amounts.put(new Tuple<>(userId, itemId), bidAmount);
        this.higher.computeIfAbsent(itemId, p ->
                new PriorityQueue<>((p1, p2) -> {
                    if (p1[1] == p2[1]) {
                        return Integer.compare(p2[0], p1[0]);
                    } else {
                        return Integer.compare(p2[1], p1[1]);
                    }
                })).add( new int[] {userId, bidAmount});
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        this.amounts.put(new Tuple<>(userId, itemId), newAmount);
        this.higher.computeIfAbsent(itemId, p ->
                new PriorityQueue<>((p1, p2) -> {
                    if (p1[1] == p2[1]) {
                        return Integer.compare(p2[0], p1[0]);
                    } else {
                        return Integer.compare(p2[1], p1[1]);
                    }
                })).add( new int[] {userId, newAmount});
    }

    public void removeBid(int userId, int itemId) {
        this.amounts.remove(new Tuple<>(userId, itemId));
    }

    public int getHighestBidder(int itemId) {
        if (!this.higher.containsKey(itemId)) return -1;
        while (!this.higher.get(itemId).isEmpty()) {
            PriorityQueue<int[]> h = this.higher.get(itemId);
            int[] entry = h.peek();
            Integer amount = this.amounts.get(new Tuple<>(entry[0], itemId));
            if (amount != null && amount == entry[1]) {
                return entry[0];
            } else {
                h.poll();
            }
        }
        return -1;
    }
}
