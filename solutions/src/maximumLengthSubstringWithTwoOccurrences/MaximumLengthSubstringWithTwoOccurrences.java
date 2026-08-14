package maximumLengthSubstringWithTwoOccurrences;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        char[] sChars = s.toCharArray();
        int[] count = new int[26];
        int maxLen = -1;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int ch = sChars[r] - 'a';
            count[ch]++;
            while (count[ch] > 2) {
                count[sChars[l] - 'a']--;
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen;
    }
}
