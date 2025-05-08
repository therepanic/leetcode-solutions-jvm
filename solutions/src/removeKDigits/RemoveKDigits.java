package removeKDigits;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int ogK = k;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> nums = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            int numVal = Character.digit(c, 10);
            while (!nums.isEmpty() && nums.getLast() > numVal && k != 0) {
                nums.pollLast();
                k--;
            }
            nums.addLast(numVal);
        }
        while (!nums.isEmpty() && num.length() - nums.size() != ogK) {
            nums.pollLast();
        }
        while (!nums.isEmpty() && nums.getFirst() == 0) {
            nums.pollFirst();
        }
        for (int val : nums) {
            sb.append(val);
        }
        if (sb.isEmpty()) {
            return "0";
        }
        return sb.toString();
    }
}
