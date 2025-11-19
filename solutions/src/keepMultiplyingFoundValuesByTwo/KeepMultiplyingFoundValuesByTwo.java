package keepMultiplyingFoundValuesByTwo;

public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        boolean[] seen = new boolean[1001];
        for (int val : nums) {
            seen[val] = true;
        }
        while (seen[original]) {
            original *= 2;
        }
        return original;
    }
}
