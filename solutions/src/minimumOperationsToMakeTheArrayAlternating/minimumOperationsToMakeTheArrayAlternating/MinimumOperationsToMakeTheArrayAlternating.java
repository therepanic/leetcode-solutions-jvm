package minimumOperationsToMakeTheArrayAlternating.minimumOperationsToMakeTheArrayAlternating;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        int evenVal = Integer.MAX_VALUE - 1;
        int evenPrevVal = Integer.MAX_VALUE - 1;
        int oddVal = Integer.MAX_VALUE;
        int oddPrevVal = Integer.MAX_VALUE;
        int evenMaxC = 0;
        int evenPrevMaxC = 0;
        int oddMaxC = 0;
        int oddPrevMaxC = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                int c = even.getOrDefault(nums[i], 0) + 1;
                even.put(nums[i], c);
                if (c > evenMaxC) {
                    evenMaxC = c;
                    if (nums[i] != evenVal) {
                        evenPrevVal = evenVal;
                        evenVal = nums[i];
                    }
                } else if (c > evenPrevMaxC) {
                    evenPrevMaxC = c;
                    evenPrevVal = nums[i];
                }
            } else {
                int c = odd.getOrDefault(nums[i], 0) + 1;
                odd.put(nums[i], c);
                if (c > oddMaxC) {
                    oddMaxC = c;
                    if (nums[i] != oddVal) {
                        oddPrevVal = oddVal;
                        oddVal = nums[i];
                    }
                } else if (c > oddPrevMaxC) {
                    oddPrevMaxC = c;
                    oddPrevVal = nums[i];
                }
            }
        }
        int count = 0;
        if (evenVal == oddVal) {
            int count1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0 && nums[i] != evenVal || i % 2 != 0 && nums[i] != oddPrevVal) {
                    count1++;
                }
            }
            int count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0 && nums[i] != evenPrevVal || i % 2 != 0 && nums[i] != oddVal) {
                    count2++;
                }
            }
            count = Math.min(count1, count2);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0 && nums[i] != evenVal || i % 2 != 0 && nums[i] != oddVal) {
                    count++;
                }
            }
        }
        return count;
    }
}
