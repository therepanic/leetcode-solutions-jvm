package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> letterCombinations = new ArrayList<>();
        Map<Character, String> digitLetterMap = new HashMap<>(Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        ));

        helper(letterCombinations, new StringBuilder(), digits.toCharArray(), 0, digitLetterMap);

        return letterCombinations;
    }

    public static void helper(List<String> letterCombinations, StringBuilder sb, char[] digitChars, int startIndex, Map<Character, String> digitLetterMap) {
        if (startIndex >= digitChars.length) {
            return;
        }

        char[] letterChars = digitLetterMap.get(digitChars[startIndex]).toCharArray();

        for (char letter : letterChars) {
            sb.append(letter);

            helper(letterCombinations, sb, digitChars, startIndex + 1, digitLetterMap);

            if (startIndex + 1 == digitChars.length) {
                letterCombinations.add(sb.toString());
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
