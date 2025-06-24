package findAllKDistantIndicesInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int r = 0;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != key) continue;
            int l = Math.max(r, i - k);
            r = Math.min(nums.length, i + k + 1);
            for (int j = l; j < r; j++) {
                values.add(j);
            }
        }
        return values;
    }
}