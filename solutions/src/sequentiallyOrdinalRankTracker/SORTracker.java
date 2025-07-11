package sequentiallyOrdinalRankTracker;

import java.util.TreeSet;

public class SORTracker {

    private final TreeSet<Pair<String, Integer>> values;

    private Pair<String, Integer> pair;

    private record Pair<T, K>(T first, K second) {}

    public SORTracker() {
        this.values = new TreeSet<>((p1, p2) -> {
            if (p1.second.equals(p2.second)) {
                return p1.first.compareTo(p2.first);
            } else {
                return Integer.compare(p2.second, p1.second);
            }
        });
        this.pair = new Pair<>("", Integer.MAX_VALUE);
    }

    public void add(String name, int score) {
        var pair = new Pair<>(name, score);
        this.values.add(pair);
        if (compare(pair, this.pair) < 0) {
            this.pair = this.values.lower(this.pair);
        }
    }

    private int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
        if (a.second.equals(b.second)) {
            return a.first.compareTo(b.first);
        } else {
            return Integer.compare(b.second, a.second);
        }
    }

    public String get() {
        this.pair = this.values.higher(this.pair);
        return this.pair.first;
    }

}
