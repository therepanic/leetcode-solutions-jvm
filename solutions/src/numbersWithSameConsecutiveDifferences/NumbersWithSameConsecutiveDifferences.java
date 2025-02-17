package numbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        if (k == 0) {
            for (int i = 1; i <= 9; i++) {
                int num = 0;
                for (int j = 0; j < n; j++) {
                    num = num * 10 + i;
                }
                nums.add(num);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                helper(n - 1, i, k, nums);
            }
        }
        return nums.stream().mapToInt(i -> i).toArray();
    }

    private void helper(int d, int num, int k, List<Integer> nums) {
        if (d == 0) {
            nums.add(num);
            return;
        }
        int lastNum = num % 10;
        int lastNumSum = lastNum + k;
        if (lastNumSum < 10) {
            helper(d - 1, num * 10 + lastNumSum, k, nums);
        }
        int lastNumDif = lastNum - k;
        if (lastNumDif >= 0) {
            helper(d - 1, num * 10 + lastNumDif, k, nums);
        }
    }
}
