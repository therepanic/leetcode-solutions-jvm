package separateTheDigitsInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> own = new ArrayList<>();
            int val = nums[i];
            while (val != 0) {
                own.add(val % 10);
                val /= 10;
            }
            Collections.reverse(own);
            numbers.addAll(own);
        }
        int[] ans = new int[numbers.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = numbers.get(i);
        }
        return ans;
    }
}
