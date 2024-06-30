package productOfArrayExceptSelf;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] leftInRight = new int[nums.length];
        int[] rightInLeft = new int[nums.length];

        int multiplier = 1;
        for (int i = 0; i < nums.length; i++) {
            leftInRight[i] = multiplier;

            multiplier *= nums[i];
        }

        multiplier = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightInLeft[i] = multiplier;

            multiplier *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            leftInRight[i] *= rightInLeft[i];
        }

        return leftInRight;
    }
}
