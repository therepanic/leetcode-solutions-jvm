package smallestMissingNonNegativeIntegerAfterOperations;

public class SmallestMissingNonNegativeIntegerAfterOperations {
    public int findSmallestInteger(int[] nums, int value) {
        int[] m = new int[value];
        for (int val : nums) {
            m[((val % value) + value) % value]++;
        }
        int val = 0;
        while (m[val % value] > 0) {
            val++;
            m[val % value]--;
        }
        return val;
    }
}
