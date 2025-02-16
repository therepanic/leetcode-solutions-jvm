package lastSubstringInLexicographicalOrder;

public class LastSubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        int i = 0;
        int j = 1;
        int k = 0;
        char[] sChars = s.toCharArray();
        while (j < s.length() && i + k < s.length()) {
            if (sChars[i + k] == sChars[j + k]) {
                k++;
            } else if (sChars[i + k] < sChars[j + k]){
                i = Math.max(i + k + 1, j);
                k = 0;
                j = i + 1;
            } else {
                j = j + k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }
}
