package minimumNumbersOfFunctionCallsToMakeTargetArray;

public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int increments = 0;
        int doubles = 0;
        for (int num : nums) {
            increments += Integer.bitCount(num);
            doubles = Math.max(doubles, 31 - Integer.numberOfLeadingZeros(num));
        }
        return doubles + increments;
    }
}
