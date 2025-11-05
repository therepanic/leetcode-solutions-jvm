package formArrayByConcatenatingSubarraysOfAnotherArray;

import java.util.*;

public class FormArrayByConcatenatingSubarraysOfAnotherArray {
    public boolean canChoose(int[][] groups, int[] nums) {
        int p = 0;
        for (int r = 0; r < nums.length && p < groups.length; r++) {
            if (r + groups[p].length > nums.length) break;
            boolean match = true;
            for (int k = 0; k < groups[p].length; k++) {
                if (nums[r + k] != groups[p][k]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                r += groups[p].length - 1;
                p++;
            }
        }
        return p == groups.length;
    }
}
