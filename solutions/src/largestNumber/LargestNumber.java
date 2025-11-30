package largestNumber;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (p1, p2) -> (p2 + p1).compareTo(p1 + p2));
        StringBuilder sb = new StringBuilder();
        for (int i = numStrs.length - 1; i >= 0; i--) {
            sb.append(numStrs[i]);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
