package countNumberOfDistinctIntegersAfterReverseOperations;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfDistinctIntegersAfterReverseOperations {
    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
            numSet.add(reverseDigits(num));
        }


        return numSet.size();
    }

    public static int reverseDigits(int num) {
        int rev_num = 0;
        while (num > 0) {
            rev_num = rev_num * 10 + num % 10;
            num = num / 10;
        }
        return rev_num;
    }
}
