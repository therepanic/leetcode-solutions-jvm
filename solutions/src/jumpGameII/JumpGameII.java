package jumpGameII;

public class JumpGameII {
    public static int jump(int[] nums) {
        int end = 0;
        int toIndex = 0;
        int jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            toIndex = Math.max(toIndex, i + nums[i]);

            if (i == end) {
                end = toIndex;
                jump++;
            }
        }
        return jump;
    }
}
