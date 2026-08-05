package sortEvenAndOddIndicesIndependently;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>(nums.length / 2);
        List<Integer> even = new ArrayList<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        even.sort(null);
        odd.sort(Comparator.reverseOrder());
        int evenIt = 0;
        int oddIt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even.get(evenIt);
                evenIt++;
            } else {
                nums[i] = odd.get(oddIt);
                oddIt++;
            }
        }
        return nums;
    }
}
