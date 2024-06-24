package longestConsecutiveSequence;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 1;
        Set<Integer> sortedNums = new TreeSet<>();
        TreeSet<Integer> counts = new TreeSet<>();

        for (int num : nums) {
            sortedNums.add(num);
        }

        Integer prevNum = null;
        for (int num : sortedNums) {
            if (prevNum != null && num - prevNum == 1) {
                count++;
            } else if (prevNum != null && num - prevNum != 1) {
                counts.add(count);

                count = 1;
            }

            prevNum = num;
        }

        return counts.isEmpty() ? count : Math.max(count, counts.pollLast());
    }
}
