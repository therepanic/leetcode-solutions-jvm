package happyStudents;

import java.util.Collections;
import java.util.List;

public class HappyStudents {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        nums.add(Integer.MAX_VALUE);
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 > nums.get(i) && i + 1 < nums.get(i + 1)) {
                c++;
            }
        }
        if (nums.getFirst() != 0) {
            c++;
        }
        return c;
    }
}
