package unique3DigitEvenNumbers;

import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumbers {
    public int totalNumbers(int[] digits) {
        int[] answer = new int[1];
        Set<Integer> usedDigits = new HashSet<>();
        Set<Integer> used2 = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (usedDigits.isEmpty() && digits[i] == 0) continue;
            usedDigits.add(i);
            helper(digits[i], usedDigits, used2, digits, answer);
            usedDigits.remove(i);
        }
        return answer[0];
    }

    private void helper(int curNum, Set<Integer> usedDigits, Set<Integer> used2, int[] digits, int[] answer) {
        if (usedDigits.size() == 3 && curNum % 2 == 0 && !used2.contains(curNum)) {
            answer[0]++;
            used2.add(curNum);
            return;
        } else if (usedDigits.size() == 3) {
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            if (!usedDigits.contains(i)) {
                usedDigits.add(i);
                helper(curNum * 10 + digit, usedDigits, used2, digits, answer);
                usedDigits.remove(i);
            }
        }
    }
}
