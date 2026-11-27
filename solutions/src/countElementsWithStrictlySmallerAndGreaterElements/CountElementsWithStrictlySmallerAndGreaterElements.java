package countElementsWithStrictlySmallerAndGreaterElements;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min && nums[i] < max) {
                c++;
            }
        }
        return c;
    }
}
