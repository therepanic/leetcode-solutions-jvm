package makeStringASubsequenceUsingCyclicIncrements;

public class MakeStringASubsequenceUsingCyclicIncrements {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str1.length()) return false;

        char[] str2s = str2.toCharArray();
        char[] str1s = str1.toCharArray();

        int it = 0;

        for (int i = 0; i < str1s.length && it < str2s.length; i++) {
            char str1sChar = str1s[i];
            if (str1sChar == 'z') {
                str1sChar = 'a';
            } else str1sChar++;

            if (str1s[i] == str2s[it] || str1sChar == str2s[it]) {
                it++;
            }
        }

        return it >= str2s.length;
    }
}
