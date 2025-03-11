package totalAppealOfAString;

public class TotalAppealOfAString {
    public static long appealSum(String s) {
        int[] appeal = new int[26];
        char[] sChars = s.toCharArray();
        long ans = 0;
        for (int i = 0; i < sChars.length; i++) {
            char ch = sChars[i];
            appeal[ch - 'a'] = i + 1;
            for (int it = 0; it < 26; it++) {
                ans += appeal[it];
            }
        }
        return ans;
    }
}
