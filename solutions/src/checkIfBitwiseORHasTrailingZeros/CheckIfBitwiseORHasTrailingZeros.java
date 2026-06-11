package checkIfBitwiseORHasTrailingZeros;

public class CheckIfBitwiseORHasTrailingZeros {
    public boolean hasTrailingZeros(int[] nums) {
        boolean ok = false;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                if (!ok) {
                    ok = true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
