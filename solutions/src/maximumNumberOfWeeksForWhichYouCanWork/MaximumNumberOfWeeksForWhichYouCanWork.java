package maximumNumberOfWeeksForWhichYouCanWork;

public class MaximumNumberOfWeeksForWhichYouCanWork {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int x = 0;
        for (int v : milestones) {
            sum += v;
            x = Math.max(x, v);
        }
        long rest = sum - x;
        if (x <= rest) {
            return sum;
        }
        return (long) 2 * rest + 1;
    }
}
