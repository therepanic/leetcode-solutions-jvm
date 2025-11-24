package binaryPrefixDivisibleBy5;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>(nums.length + 1);
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            val = ((val << 1) | nums[i]) % 5;
            ans.add(val % 5 == 0);
        }
        return ans;
    }
}
