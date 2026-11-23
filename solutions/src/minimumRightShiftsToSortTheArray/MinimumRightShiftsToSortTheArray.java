package minimumRightShiftsToSortTheArray;

import java.util.List;

public class MinimumRightShiftsToSortTheArray {
    public int minimumRightShifts(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int b = -1;
            boolean d = true;
            for (int j = 0; j < nums.size(); j++) {
                if (b == -1) {
                    b = nums.get((j + i) % nums.size());
                } else {
                    int c = nums.get((j + i) % nums.size());
                    if (b > c) {
                        d = false;
                        break;
                    }
                    b = c;
                }
            }
            if (d) {
                return (nums.size() - i) % nums.size();
            }
        }
        return -1;
    }
}
