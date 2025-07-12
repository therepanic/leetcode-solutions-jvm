package numberOfRecentCalls;

public class RecentCounter {

    private int start;
    private int end;
    private int[] records = new int[10000];

    public RecentCounter() {

    }

    public int ping(int t) {
        while (this.start < this.end && t - this.records[this.start] > 3000) {
            this.start++;
        }
        this.records[end++] += t;
        return end - start;
    }

}
