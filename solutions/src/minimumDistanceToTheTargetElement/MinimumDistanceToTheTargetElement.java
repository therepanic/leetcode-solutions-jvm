package minimumDistanceToTheTargetElement;

public class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                end = Math.min(end, Math.abs(i - start));
            }
        }
        return end;
    }
}
