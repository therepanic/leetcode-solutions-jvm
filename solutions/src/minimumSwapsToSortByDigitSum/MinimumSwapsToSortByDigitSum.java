package minimumSwapsToSortByDigitSum;

import java.util.Arrays;

public class MinimumSwapsToSortByDigitSum {

    static class Tuple {
        public int sum;
        public int val;
        public int it;

        public Tuple(int sum, int val, int it) {
            this.sum = sum;
            this.val = val;
            this.it = it;
        }
    }

    public int minSwaps(int[] nums) {
        Tuple[] tuples = new Tuple[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tuples[i] = new Tuple(digitSum(nums[i]), nums[i], i);
        }
        Arrays.sort(tuples, (p1, p2) -> {
            if (p1.sum == p2.sum) {
                return Integer.compare(p1.val, p2.val);
            } else {
                return Integer.compare(p1.sum, p2.sum);
            }
        });
        int swapCount = 0;
        for (int i = 0; i < tuples.length; i++) {
            if (tuples[i].it != i) {
                Tuple buff = tuples[i];
                int it = tuples[i].it;
                tuples[i] = tuples[it];
                tuples[it] = buff;
                swapCount++;
                i--;
            }
        }
        return swapCount;
    }

    public int digitSum(int num) {
        int s = 0;
        while(num != 0) {
            s += num % 10;
            num = num / 10;
        }
        return s;
    }
}
