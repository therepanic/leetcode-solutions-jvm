package antOnTheBoundary;

public class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int a = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            a += nums[i];
            if (a == 0) {
                ans++;
            }
        }
        return ans;
    }
}
