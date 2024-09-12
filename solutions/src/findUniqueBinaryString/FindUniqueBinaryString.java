package findUniqueBinaryString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder binaryString = new StringBuilder();

        Set<String> binaryStrings = new HashSet<>(Arrays.asList(nums));

        String[] answer = new String[1];

        helper(binaryString, binaryStrings, answer);

        return answer[0];
    }

    public void helper(StringBuilder binaryString, Set<String> binaryStrings, String[] answer) {
        if (answer[0] != null) {
            return;
        }

        binaryString.append("0");

        if (binaryString.length() == binaryStrings.size()) {
            if (!binaryStrings.contains(binaryString.toString())) {
                answer[0] = binaryString.toString();
                return;
            }
        } else {
            helper(binaryString, binaryStrings, answer);
        }

        binaryString.deleteCharAt(binaryString.length() - 1);

        binaryString.append("1");

        if (binaryString.length() == binaryStrings.size()) {
            if (!binaryStrings.contains(binaryString.toString())) {
                answer[0] = binaryString.toString();
                return;
            }
        } else {
            helper(binaryString, binaryStrings, answer);
        }

        binaryString.deleteCharAt(binaryString.length() - 1);
    }
}
