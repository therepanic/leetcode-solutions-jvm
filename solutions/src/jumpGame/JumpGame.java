package jumpGame;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int toIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > toIndex) {
                return false;
            }
            toIndex = Math.max(toIndex, nums[i] + i);
        }

        return true;
    }
}
