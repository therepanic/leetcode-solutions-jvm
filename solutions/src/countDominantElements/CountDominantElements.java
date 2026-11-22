package countDominantElements;

public class CountDominantElements {
    public int countDominantElements(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = 0;
            int c = 0;
            if (i > 0) {
                c++;
                a += nums[i - 1];
            }
            if (i < nums.length - 1) {
                c++;
                a += nums[i + 1];
            }
            if ((double) a / c <= nums[i]) {
                ans++;
            }
        }
        return ans;
    }
}
