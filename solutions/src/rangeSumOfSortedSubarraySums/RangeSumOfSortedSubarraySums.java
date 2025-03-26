package rangeSumOfSortedSubarraySums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            numList.add(c);
            for (int j = i + 1; j < nums.length; j++) {
                c += nums[j];
                numList.add(c);
            }
        }
        Collections.sort(numList);
        int c = 0;
        for (int i = left - 1; i < right; i++) {
            c = (int) (((long) c + numList.get(i)) % (1e9 + 7));
        }
        return c;
    }
}
