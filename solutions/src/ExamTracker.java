import java.util.TreeMap;

public class ExamTracker {

    private final TreeMap<Integer, Long> map = new TreeMap<>();
    private final TreeMap<Integer, Long> prefix = new TreeMap<>();

    public ExamTracker() {

    }

    public void record(int time, int score) {
        map.put(time, (long) score);
        long b = prefix.lowerEntry(time) != null ? prefix.lowerEntry(time).getValue() : 0;
        long current = b;
        for (var e : map.tailMap(time, true).entrySet()) {
            current += e.getValue();
            prefix.put(e.getKey(), current);
        }
    }

    public long totalScore(int startTime, int endTime) {
        var endEntry = prefix.floorEntry(endTime);
        var startEntry = prefix.lowerEntry(startTime);
        long endSum = endEntry != null ? endEntry.getValue() : 0;
        long startSum = startEntry != null ? startEntry.getValue() : 0;
        return endSum - startSum;
    }
}
