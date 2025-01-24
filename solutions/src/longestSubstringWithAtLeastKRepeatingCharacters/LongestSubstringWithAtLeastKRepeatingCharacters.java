package longestSubstringWithAtLeastKRepeatingCharacters;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        char[] sChars = s.toCharArray();
        int maxLength = 0;
        for (int m = 1; m <= 26; m++) {
            int countNeed = 0;
            int curSit = 0;
            int[] counts = new int[26];

            int l = 0;
            for (int r = 0; r < sChars.length; r++) {
                int rChar = sChars[r] - 'a';
                if (counts[rChar] == 0) curSit++;
                counts[rChar]++;
                if (counts[rChar] == k) countNeed++;

                while (curSit > m) {
                    int lChar = sChars[l] - 'a';
                    if (counts[lChar] == k) countNeed--;
                    counts[lChar]--;
                    if (counts[lChar] == 0) curSit--;
                    l++;
                }
                if (countNeed == m && curSit == m) {
                    maxLength = Math.max(maxLength, r - l + 1);
                }
            }
        }
        return maxLength;
    }
}
