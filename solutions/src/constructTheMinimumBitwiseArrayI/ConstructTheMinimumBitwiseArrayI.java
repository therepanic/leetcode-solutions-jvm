package constructTheMinimumBitwiseArrayI;

import java.util.List;

public class ConstructTheMinimumBitwiseArrayI {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            int r = -1;
            int d = 1;
            while ((x & d) != 0) {
                r = x - d;
                d <<= 1;
            }
            ans[i] = r;
        }
        return ans;
    }
}
