package lengthOfTheLongestAlphabeticalContinuousSubstring;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int l = 0;
        int maxSize = 0;
        char[] sChars = s.toCharArray();
        for (int i = 1; i < sChars.length; i++) {
            int a = sChars[i - 1] - 'a';
            int b = sChars[i] - 'a';
            if (b - a != 1) {
                maxSize = Math.max(i - l, maxSize);
                l = i;
            }
        }
        maxSize = Math.max(s.length() - l, maxSize);
        return maxSize;
    }
}
