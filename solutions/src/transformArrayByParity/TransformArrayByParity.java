package transformArrayByParity;

public class TransformArrayByParity {
    public int[] transformArray(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                zero++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero != 0) {
                nums[i] = 0;
                zero--;
            } else {
                nums[i] = 1;
            }
        }
        return nums;
    }
}
