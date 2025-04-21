package countTheHiddenSequences;

public class CountTheHiddenSequences {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count = 0;
        int first = 0;
        int second = 0;
        for (int diff : differences) {
            count += diff;
            first = Math.max(count, first);
            second = Math.min(count, second);
            if (first - second > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (first - second) + 1;
    }
}
