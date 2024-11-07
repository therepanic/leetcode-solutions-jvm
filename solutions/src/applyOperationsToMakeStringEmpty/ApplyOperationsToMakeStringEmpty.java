package applyOperationsToMakeStringEmpty;

public class ApplyOperationsToMakeStringEmpty {
    public static String lastNonEmptyString(String s) {
        char[] sChars = s.toCharArray();
        int[] chars = new int[26];

        int maxCount = 0;
        for (char c : sChars) {
            maxCount = Math.max(maxCount, ++chars[c - 'a']);
        }
        maxCount--;

        int[] newChars = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char c : sChars) {
            if (++newChars[c - 'a'] > maxCount) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
