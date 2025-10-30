package minimumNumberOfIncrementsOnSubarraysToFormATargetArray;

public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public int minNumberOperations(int[] target) {
        int c = target[0];
        for (int i = 1; i < target.length; i++) {
            c += Math.max(target[i] - target[i - 1], 0);
        }
        return c;
    }
}
