package findMinimumOperationsToMakeAllElementsDivisibleByThree;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public int minimumOperations(int[] nums) {
        int c = 0;
        for (int val : nums) {
            if (val % 3 != 0) {
                c++;
            }
        }
        return c;
    }
}
