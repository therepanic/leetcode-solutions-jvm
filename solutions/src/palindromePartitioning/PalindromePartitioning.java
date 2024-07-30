package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        check(answer, new ArrayList<>(), s.toCharArray(), 0);

        return answer;
    }

    public static void check(List<List<String>> answer, List<String> perm, char[] sChars, int startIndex) {
        if (startIndex >= sChars.length) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = startIndex; i < sChars.length; i++) {
            sb.append(sChars[i]);

            if (isPalindrome(sb.toString())) {
                perm.add(sb.toString());
                check(answer, perm, sChars, i + 1);

                if (i + 1 == sChars.length) {
                    answer.add(new ArrayList<>(perm));
                }

                perm.remove(perm.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String word) {
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length / 2; i++) {
            if (wordChars[i] != wordChars[wordChars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
