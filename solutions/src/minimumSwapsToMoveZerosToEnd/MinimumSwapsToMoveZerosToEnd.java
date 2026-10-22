package minimumSwapsToMoveZerosToEnd;

public class MinimumSwapsToMoveZerosToEnd {
    public int minimumSwaps(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
        }
        int swap = 0;
        for (int i = nums.length - 1; i >= 0 && zero != 0; i--) {
            if (nums[i] != 0) {
                swap++;
            }
            zero--;
        }
        return swap;
    }
}
